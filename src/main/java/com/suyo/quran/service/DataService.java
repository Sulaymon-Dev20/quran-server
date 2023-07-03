package com.suyo.quran.service;

import com.suyo.quran.models.Language;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.function.Function;

@Service
public class DataService {
    final JSONArray chapterList;
    final JSONObject chapter;
    final JSONObject chapterBN;
    final JSONObject chapterEN;
    final JSONObject chapterES;
    final JSONObject chapterFR;
    final JSONObject chapterID;
    final JSONObject chapterRU;
    final JSONObject chapterSV;
    final JSONObject chapterTR;
    final JSONObject chapterUR;
    final JSONObject chapterUZ;
    final JSONObject chapterZH;
    final JSONArray juzList;

    {
        try {
            chapterList = new JSONArray(new String(Files.readAllBytes(Path.of("data/chapters.json"))));
            chapter = new JSONObject(new String(Files.readAllBytes(Path.of("data/quran.json"))));
            chapterBN = new JSONObject(new String(Files.readAllBytes(Path.of("data/editions/bn.json"))));
            chapterEN = new JSONObject(new String(Files.readAllBytes(Path.of("data/editions/en.json"))));
            chapterES = new JSONObject(new String(Files.readAllBytes(Path.of("data/editions/es.json"))));
            chapterFR = new JSONObject(new String(Files.readAllBytes(Path.of("data/editions/fr.json"))));
            chapterID = new JSONObject(new String(Files.readAllBytes(Path.of("data/editions/id.json"))));
            chapterRU = new JSONObject(new String(Files.readAllBytes(Path.of("data/editions/ru.json"))));
            chapterSV = new JSONObject(new String(Files.readAllBytes(Path.of("data/editions/sv.json"))));
            chapterTR = new JSONObject(new String(Files.readAllBytes(Path.of("data/editions/tr.json"))));
            chapterUR = new JSONObject(new String(Files.readAllBytes(Path.of("data/editions/ur.json"))));
            chapterUZ = new JSONObject(new String(Files.readAllBytes(Path.of("data/editions/uz.json"))));
            chapterZH = new JSONObject(new String(Files.readAllBytes(Path.of("data/editions/zh.json"))));
            juzList = new JSONArray(new String(Files.readAllBytes(Path.of("data/juz.json"))));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Object> getChapterListByLanguage(Language language) {
        String fieldName = getFieldName(language);
        return !fieldName.equals("ALL") ? new ArrayList<>(chapterList.toList())
                .stream()
                .peek(item -> {
                    HashMap<String, Object> chapter = (HashMap) item;
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
                    chapter.remove("translation_uz");
                    chapter.remove("translation_zh");
                }).toList() : chapterList.toList();
    }

    public Map<String, Object> getChapterSource(Language language) {
        var item = switch (language) {
            case BN -> chapterBN;
            case EN -> chapterEN;
            case ES -> chapterES;
            case FR -> chapterFR;
            case ID -> chapterID;
            case RU -> chapterRU;
            case SV -> chapterSV;
            case TR -> chapterTR;
            case UR -> chapterUR;
            case UZ -> chapterUZ;
            case ZH -> chapterZH;
            default -> chapter;
        };
        TreeMap<String, Object> res = new TreeMap<>(Comparator.comparingInt(String::length).thenComparing(Function.identity()));
        res.putAll(item.toMap());
        return res;
    }

    public Object getChapterByNumber(Language language, Integer chapterNumber) {
        return getChapterSource(language).get(chapterNumber.toString());
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
            case UZ -> "translation_uz";
            case ZH -> "translation_zh";
            default -> "ALL";
        };
    }

    public List<Object> getJuz() {
        return juzList.toList();
    }
}
