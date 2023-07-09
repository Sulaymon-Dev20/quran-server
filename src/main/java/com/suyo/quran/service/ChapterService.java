package com.suyo.quran.service;

import com.suyo.quran.models.Language;
import com.suyo.quran.models.chapter.Chapter;
import org.json.JSONArray;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import static com.suyo.quran.service.DataService.classloader;

@Service
public class ChapterService {

    final JSONArray chapterList = new JSONArray(new String(Objects.requireNonNull(classloader.getResourceAsStream("data/chapters.json")).readAllBytes()));
    final DataService dataService;

    public ChapterService(DataService service) throws IOException {
        this.dataService = service;
    }

    public List<Chapter> getChapterListByLanguage(Language language) {
        return chapterList.toList().stream().map(item -> new Chapter((HashMap<String, Object>) item, language)).toList();
    }
}
