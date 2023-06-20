package com.suyo.quran.service;

import com.suyo.quran.models.Language;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class DataService {
    final JSONArray jsonArray;

    {
        try {
            Path path = Path.of("chapters.json");
            String source = new String(Files.readAllBytes(path));
            jsonArray = new JSONArray(source);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public JSONArray getChapter() {
        return jsonArray;
    }

    public List<Object> getChapter(Language language) {
        String fieldName = getFieldName(language);
        if (!fieldName.equals("ALL")) {
            return new ArrayList<>(jsonArray.toList())
                    .stream()
                    .peek(item -> {
                        HashMap chapter = (HashMap) item;
                        chapter.put("translation", chapter.get(fieldName));
                        chapter.remove("translation_bn");
                        chapter.remove("translation_en");
                        chapter.remove("translation_es");
                        chapter.remove("translation_fr");
                        chapter.remove("translation_id");
                        chapter.remove("translation_ru");
                        chapter.remove("translation_sv");
                        chapter.remove("translation_tr");
                        chapter.remove("translation_ur");
                        chapter.remove("translation_zh");
                    }).toList();
        } else {
            return jsonArray.toList();
        }
    }

    private String getFieldName(Language language) {
        return switch (language) {
            case BN -> "translation_bn";
            case EN -> "translation_en";
            case ES -> "translation_es";
            case FR -> "translation_fr";
            case ID -> "translation_id";
            case RU -> "translation_ru";
            case SV -> "translation_sv";
            case TR -> "translation_tr";
            case UR -> "translation_ur";
            case ZH -> "translation_zh";
            default -> "ALL";
        };
    }
}
