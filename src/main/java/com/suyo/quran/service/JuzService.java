package com.suyo.quran.service;

import com.suyo.quran.entities.enums.Language;
import com.suyo.quran.models.juz.JuzModel;
import org.json.JSONArray;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import static com.suyo.quran.service.DataService.classloader;

@Service
public class JuzService {
    final JSONArray juzList = new JSONArray(new String(Objects.requireNonNull(classloader.getResourceAsStream("data/juz.json")).readAllBytes()));

    public JuzService() throws IOException {
    }

    public List<JuzModel> getJuz(Language language) {
        return juzList.toList().stream().map(item -> new JuzModel((HashMap<String, Object>) item, language)).toList();
    }
}
