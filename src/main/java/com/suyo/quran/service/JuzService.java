package com.suyo.quran.service;

import com.suyo.quran.models.Response;
import org.springframework.stereotype.Service;

@Service
public class JuzService {

    final DataService dataService;

    public JuzService(DataService dataService) {
        this.dataService = dataService;
    }

    public Response getJuz() {
        return null;
    }
}
