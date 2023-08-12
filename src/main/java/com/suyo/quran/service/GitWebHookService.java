package com.suyo.quran.service;

import com.suyo.quran.service.telegram.TelegramConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class GitWebHookService {
    private final TelegramConfig telegramConfig;

    public void sendToTelegram(String token, Map<String, Object> data) {
        final String objectKind = (String) data.get("object_kind");
        String message = switch (objectKind) {
            case "push" -> pushHook(data);
            case "pipeline" -> pipelineHook(data);
            case "tag_push" -> tagPushHook(data);
            default -> defaultHook(data);
        };
        telegramConfig.sendNotification(token, message);
    }

    private String defaultHook(Map<String, Object> data) {
        StringBuilder s = new StringBuilder();
        final Map<String, Object> project = (Map<String, Object>) data.get("project");
        s.append("<b>project:</b> <a href='").append(project.get("web_url")).append("'>").append(project.get("name")).append("</a>\n");
        s.append("<b>hashtag:</b> #").append(data.get("object_kind")).append("\n");
        s.append("<b>ref:</b> ").append(data.get("ref"));
        return s.toString();
    }

    private String tagPushHook(Map<String, Object> data) {
        StringBuilder s = new StringBuilder();
        final Map<String, Object> project = (Map<String, Object>) data.get("project");
        s.append("<b>project:</b> <a href='").append(project.get("web_url")).append("'>").append(project.get("name")).append("</a>\n");
        s.append("<b>hashtag:</b> #tag\n");
        s.append("<b>ref:</b> ").append(data.get("ref"));
        return s.toString();
    }

    private String pipelineHook(Map<String, Object> data) {
        StringBuilder s = new StringBuilder();
        final Map<String, Object> project = (Map<String, Object>) data.get("project");
        final Map<String, Object> objectAttributes = (Map<String, Object>) data.get("object_attributes");
        final Map<String, Object> user = (Map<String, Object>) data.get("user");
        s.append("<b>project:</b> <a href='").append(project.get("web_url")).append("'>").append(project.get("name")).append("</a>\n");
        s.append("<b>hashtag:</b> #pipeline\n");
        s.append("<b>status:</b> <a href='").append(objectAttributes.get("url")).append("'>").append(objectAttributes.get("status")).append("</a>").append("\n");
        s.append("<b>duration:</b> ").append(objectAttributes.get("duration")).append("\n");
        s.append("<b>ref:</b> ").append(objectAttributes.get("ref")).append("\n");
        s.append("<b>developer:</b> ").append(user.get("name")).append("\n");

        List<Map<String, Object>> builds = (List<Map<String, Object>>) data.get("builds");
        final String reduce = builds.stream().map(item -> "\nname: " + item.get("name") + "\nstage: " + item.get("stage") + "\nstatus: " + item.get("status") + "\nduration: " + item.get("duration") + "\n").reduce("", String::concat);
        s.append(reduce);
        return s.toString();
    }

    private String pushHook(Map<String, Object> data) {
        StringBuilder s = new StringBuilder();
        final Map<String, Object> project = (Map<String, Object>) data.get("project");
        s.append("<b>project:</b> <a href='").append(project.get("web_url")).append("'>").append(project.get("name")).append("</a>\n");
        s.append("<b>hashtag:</b> #push\n");
        s.append("<b>developer:</b> <a href='mailto:").append(data.get("user_email")).append("'>").append(data.get("user_name")).append("</a>").append("\n");
        s.append("<b>compare:</b> <a href='").append(project.get("web_url")).append("/-/compare/").append(data.get("before")).append("...").append(data.get("after")).append("'> (Compare changes) </a>\n");
        s.append("<b>total commands:</b> ").append(data.get("total_commits_count")).append("\n");
        s.append(commit((List<Map<String, Object>>) data.get("commits")));
        return s.toString();
    }

    private String commit(List<Map<String, Object>> commits) {
        return commits.stream()
            .map(item -> "\n<b>message:</b> <a href='" + item.get("url") + "'>" + item.get("message") + "</a><b>author:</b> " + ((Map<String, Object>) item.get("author")).get("name") + "\n<b>time:</b> " + item.get("timestamp") + "\n")
            .reduce("", String::concat);
    }
}
