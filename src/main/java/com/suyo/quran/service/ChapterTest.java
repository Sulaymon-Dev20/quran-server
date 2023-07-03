package com.suyo.quran.service;

import lombok.SneakyThrows;
import org.json.JSONArray;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class ChapterTest {
    @SneakyThrows
    public static void main(String[] args) {
        List<Object> chapters = new JSONArray(Files.readString(Path.of(".\\data\\chapters.json"))).toList();
        for (Object chapter : chapters) {
            HashMap map = (HashMap) chapter;
            LinkedHashMap<Object, Object> translation = new LinkedHashMap<>(11);
            translation.put("tr", map.remove("translation_tr"));
            translation.put("id", map.remove("translation_id"));
            translation.put("fr", map.remove("translation_fr"));
            translation.put("uz", map.remove("translation_uz"));
            translation.put("ur", map.remove("translation_ur"));
            translation.put("bn", map.remove("translation_bn"));
            translation.put("es", map.remove("translation_es"));
            translation.put("zh", map.remove("translation_zh"));
            translation.put("ru", map.remove("translation_ru"));
            translation.put("sv", map.remove("translation_sv"));
            translation.put("en", map.remove("translation_en"));
            map.put("translation", translation);
        }
        Files.writeString(Path.of("chapters.json"), new JSONArray(chapters).toString(), StandardCharsets.UTF_8);
    }
}
