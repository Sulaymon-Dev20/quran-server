package com.suyo.quran.service;

import com.suyo.quran.models.Language;
import com.suyo.quran.models.Response;
import com.suyo.quran.models.Status;
import org.springframework.stereotype.Service;

@Service
public class JuzService {

    final DataService dataService;

    public JuzService(DataService dataService) {
        this.dataService = dataService;
    }

    public Response getJuz(Language language) {
        return new Response(new Status(200), dataService.getJuz(language));
    }
}
