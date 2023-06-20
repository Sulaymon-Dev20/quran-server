package com.suyo.quran.service;

import com.suyo.quran.models.Language;
import com.suyo.quran.models.Response;
import com.suyo.quran.models.Status;
import org.springframework.stereotype.Service;

@Service
public class ChapterService {

    final DataService dataService;

    public ChapterService(DataService service) {
        this.dataService = service;
    }

    public Response getChapterByLanguage(Language language) {
        return new Response(new Status(200), dataService.getChapter(language));
    }
}
