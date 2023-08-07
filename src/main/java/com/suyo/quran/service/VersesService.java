package com.suyo.quran.service;

import com.suyo.quran.entities.enums.Language;
import com.suyo.quran.models.nonAuth.verses.Verse;
import org.json.JSONArray;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class VersesService {
    final JSONArray versesList = new JSONArray(DataService.getTemplate("data/verses.json"));

    public List<List<Verse>> getAllChapter(Language language) {
        return versesList.toList().stream().map(chapter -> ((List<HashMap<String, Object>>) chapter).stream().map(verse -> new Verse(verse, language)).toList()).toList();
    }

    public List<Verse> getChapter(Language language, Integer chapterNumber) {
        return getAllChapter(language).get(chapterNumber - 1);
    }
}
