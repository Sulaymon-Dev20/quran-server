package com.suyo.quran.service;

import com.suyo.quran.entities.enums.Language;
import com.suyo.quran.models.nonAuth.chapter.Chapter;
import org.json.JSONArray;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class ChapterService {

    final JSONArray chapterList = new JSONArray(DataService.getTemplate("data/chapters.json"));

    public List<Chapter> getChapterListByLanguage(Language language) {
        return chapterList.toList().stream().map(item -> new Chapter((HashMap<String, Object>) item, language)).toList();
    }
}
