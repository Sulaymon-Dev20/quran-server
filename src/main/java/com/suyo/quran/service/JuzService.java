package com.suyo.quran.service;

import com.suyo.quran.entities.enums.Language;
import com.suyo.quran.models.nonAuth.juz.JuzModel;
import org.json.JSONArray;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class JuzService {
    final JSONArray juzList = new JSONArray(DataService.getTemplate("data/juz.json"));

    public List<JuzModel> getJuz(Language language) {
        return juzList.toList().stream().map(item -> new JuzModel((HashMap<String, Object>) item, language)).toList();
    }
}
