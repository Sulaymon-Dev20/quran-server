package com.suyo.quran.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.json.JSONArray;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class JuzTest {
    @SneakyThrows
    public static void main(String[] args) {
        List<Object> juzList = new JSONArray(Files.readString(Path.of(".\\data\\juz.json"))).toList();
        List<Object> chapters = new JSONArray(Files.readString(Path.of(".\\data\\chapters.json"))).toList();
        int count = 0;
        for (Object o : juzList) {
            HashMap map = (HashMap) o;
            ArrayList<HashMap> chapter = (ArrayList<HashMap>) map.getOrDefault("chapters", new ArrayList<>());
            for (HashMap surah : chapter) {
                surah.remove("title");
                Object titleAr = surah.remove("titleAr");
                surah.put("pageNumber", Integer.parseInt((String) surah.get("pageNumber")));
                HashMap map1 = (HashMap) chapters.get(((int) surah.get("index")) - 1);
                LinkedHashMap<Object, Object> translation = new LinkedHashMap<>(11);
                translation.put("ar", titleAr);
                translation.put("tr", map1.get("translation_tr"));
                translation.put("id", map1.get("translation_id"));
                translation.put("fr", map1.get("translation_fr"));
                translation.put("uz", map1.get("translation_uz"));
                translation.put("ur", map1.get("translation_ur"));
                translation.put("bn", map1.get("translation_bn"));
                translation.put("es", map1.get("translation_es"));
                translation.put("zh", map1.get("translation_zh"));
                translation.put("ru", map1.get("translation_ru"));
                translation.put("sv", map1.get("translation_sv"));
                translation.put("en", map1.get("translation_en"));
                surah.put("translation", translation);
                count++;
            }
//            Files.writeString(Path.of("juz.json"), new ObjectMapper().writeValueAsString(res), StandardCharsets.UTF_8);
        }
        Files.writeString(Path.of("juz.json"), new JSONArray(juzList).toString(), StandardCharsets.UTF_8);
    }
}
