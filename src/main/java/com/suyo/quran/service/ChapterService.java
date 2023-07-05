package com.suyo.quran.service;

import com.suyo.quran.models.Language;
import com.suyo.quran.models.Response;
import com.suyo.quran.models.Status;
import com.suyo.quran.repository.ChapterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChapterService {

    final DataService dataService;

    final ChapterRepository chapterRepository;

    public ChapterService(DataService service, ChapterRepository chapterRepository) {
        this.dataService = service;
        this.chapterRepository = chapterRepository;
    }

    public Response getChapterListByLanguage(Language language) {
        return new Response(new Status(200), dataService.getChapterListByLanguage(language));
    }

    public Response getChapterList(Language language) {
        return new Response(new Status(200), chapterRepository.findAll());
    }
}
