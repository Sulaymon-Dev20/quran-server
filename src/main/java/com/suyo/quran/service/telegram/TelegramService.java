package com.suyo.quran.service.telegram;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.polls.SendPoll;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.List;

@Service
public class TelegramService {
    private void sendText(Message message, String text) {
        final SendMessage sendMessage = new SendMessage();
        sendMessage.setText("yaxshi <b>yasxhi</b>");
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setParseMode("html");
        sendMessage.setReplyToMessageId(message.getMessageId());
    }

    private void sendPoll(Message message, String text) {
        final SendPoll sav = new SendPoll();
        sav.setChatId(message.getChatId().toString());
        sav.setOptions(List.of("asdf", "asdf", "asdf", "asdf"));
        sav.setQuestion("uzb ???");
        sav.setExplanation("asdfjaskdf");
        sav.setExplanationParseMode("html");
        sav.setType("quiz");
    }
}
