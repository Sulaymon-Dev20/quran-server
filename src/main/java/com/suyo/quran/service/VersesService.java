package com.suyo.quran.service;

import com.suyo.quran.models.Language;
import com.suyo.quran.models.verses.Verse;
import org.json.JSONArray;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import static com.suyo.quran.service.DataService.classloader;

@Service
public class VersesService {
    final JSONArray versesList = new JSONArray(new String(Objects.requireNonNull(classloader.getResourceAsStream("data/verses.json")).readAllBytes()));

    public VersesService() throws IOException {
    }

    public List<List<Verse>> getAllChapter(Language language) {
        return versesList.toList().stream().map(chapter -> ((List<HashMap<String, Object>>) chapter).stream().map(verse -> new Verse(verse, language)).toList()).toList();
    }

    public List<Verse> getChapter(Language language, Integer chapterNumber) {
        return getAllChapter(language).get(chapterNumber - 1);
    }
}
