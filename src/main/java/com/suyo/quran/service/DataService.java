package com.suyo.quran.service;

import com.suyo.quran.models.Language;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;
import java.util.function.Function;

@Service
public class DataService {
    ClassLoader classloader = Thread.currentThread().getContextClassLoader();
    final JSONArray chapterList = new JSONArray(new String(Objects.requireNonNull(classloader.getResourceAsStream("data/chapters.json")).readAllBytes()));
    final JSONObject chapter = new JSONObject(new String(Objects.requireNonNull(classloader.getResourceAsStream("data/quran.json")).readAllBytes()));
    final JSONObject chapterBN = new JSONObject(new String(Objects.requireNonNull(classloader.getResourceAsStream("data/editions/bn.json")).readAllBytes()));
    final JSONObject chapterEN = new JSONObject(new String(Objects.requireNonNull(classloader.getResourceAsStream("data/editions/en.json")).readAllBytes()));
    final JSONObject chapterES = new JSONObject(new String(Objects.requireNonNull(classloader.getResourceAsStream("data/editions/es.json")).readAllBytes()));
    final JSONObject chapterFR = new JSONObject(new String(Objects.requireNonNull(classloader.getResourceAsStream("data/editions/fr.json")).readAllBytes()));
    final JSONObject chapterID = new JSONObject(new String(Objects.requireNonNull(classloader.getResourceAsStream("data/editions/id.json")).readAllBytes()));
    final JSONObject chapterRU = new JSONObject(new String(Objects.requireNonNull(classloader.getResourceAsStream("data/editions/ru.json")).readAllBytes()));
    final JSONObject chapterSV = new JSONObject(new String(Objects.requireNonNull(classloader.getResourceAsStream("data/editions/sv.json")).readAllBytes()));
    final JSONObject chapterTR = new JSONObject(new String(Objects.requireNonNull(classloader.getResourceAsStream("data/editions/tr.json")).readAllBytes()));
    final JSONObject chapterUR = new JSONObject(new String(Objects.requireNonNull(classloader.getResourceAsStream("data/editions/ur.json")).readAllBytes()));
    final JSONObject chapterUZ = new JSONObject(new String(Objects.requireNonNull(classloader.getResourceAsStream("data/editions/uz.json")).readAllBytes()));
    final JSONObject chapterZH = new JSONObject(new String(Objects.requireNonNull(classloader.getResourceAsStream("data/editions/zh.json")).readAllBytes()));
    final JSONArray juzList = new JSONArray(new String(Objects.requireNonNull(classloader.getResourceAsStream("data/juz.json")).readAllBytes()));

    public DataService() throws IOException {

    }

    public List<Object> getChapterListByLanguage(Language language) {
        String fieldName = getFieldName(language);
        return !fieldName.equals("All") ? new ArrayList<>(chapterList.toList())
                .stream()
                .peek(item -> {
                    HashMap<String, Object> chapter = (HashMap) item;
                    HashMap translate = (HashMap) chapter.remove("translation");
                    chapter.put("translation", translate.get(fieldName));
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
        return language == Language.DEFAULT ? "All" : language.toString().toLowerCase();
    }

    public List<Object> getJuz(Language language) {
        String fieldName = getFieldName(language);
        return !fieldName.equals("All") ? new ArrayList<>(juzList.toList())
                .stream()
                .peek(item -> {
                    HashMap<String, Object> chapter = (HashMap) item;
                    ArrayList<HashMap> list = (ArrayList<HashMap>) chapter.get("chapters");
                    for (HashMap surah : list) {
                        surah.put("translation", ((HashMap) surah.remove("translation")).get(fieldName));
                    }
                }).toList() : juzList.toList();
    }
}
