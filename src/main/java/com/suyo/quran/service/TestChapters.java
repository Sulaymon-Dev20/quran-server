package com.suyo.quran.service;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class TestChapters {

    static TreeMap<Integer, Map<String, Object>> list = new TreeMap<>();

    public static void main(String[] args) {
        try {
            File folder = new File("C:\\Users\\User\\IdeaProjects\\quran-json\\dist\\chapters");
            File[] files = folder.listFiles();
            for (int i = 0; i < 114; i++) {
                for (File file : files) {
                    File[] surah = file.listFiles();
                    collecter(file.getName(), surah[i]);
                }
                String reduce = list.values()
                        .stream()
                        .map(JSONObject::new)
                        .map(JSONObject::toString)
                        .map(item -> item.concat(","))
                        .reduce("", String::concat);
                saveFile(String.valueOf(i), "[" + reduce.substring(0, reduce.length() - 1) + "]");
                list.clear();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void collecter(String languageShortForm, File file) {
        try {
            String number = file.getName().replace(".json", "");
            String source = new String(Files.readAllBytes(Path.of(file.getPath())));
            JSONObject object = new JSONObject(source);
            int id = object.getInt("id");
            Map<String, Object> jj = list.computeIfAbsent(Integer.valueOf(number), key -> list.getOrDefault(key, new LinkedHashMap<>()));
            jj.put("id", id);
            jj.put("name", object.get("name"));
            jj.put("transliteration", object.get("transliteration"));
            jj.put("type", object.get("type"));
            jj.put("total_verses", object.get("total_verses"));
            TreeMap<Integer, Object> verses = (TreeMap<Integer, Object>) jj.computeIfAbsent("verses", key -> new TreeMap<Integer, Object>());
            object.getJSONArray("verses").forEach(item -> {
                JSONObject ff = (JSONObject) item;
                int idSurah = ff.getInt("id");
                LinkedHashMap obj = (LinkedHashMap) verses.computeIfAbsent(idSurah, value -> new LinkedHashMap<>());
                obj.put("id", idSurah);
                obj.put("text", ff.get("text"));
                obj.put("translation_" + languageShortForm, ff.remove("translation"));
                obj.put("transliteration", ff.get("transliteration"));
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void saveFile(String name, String data) {
        try {
            FileWriter myWriter = new FileWriter(name + "quran.json");
            myWriter.write(data);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
