package com.suyo.quran.test;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Test {

    static TreeMap<Integer, Map<String, Object>> list = new TreeMap<>();

    public static void main(String[] args) {
        try {
            File folder = new File("C:\\Users\\User\\IdeaProjects\\quran\\src\\main\\resources\\data\\chapters\\");
            File[] files = folder.listFiles();
            for (File file : files) {
                collecter(file);
            }
            String reduce = list.values()
                    .stream()
                    .map(JSONObject::new)
                    .map(JSONObject::toString)
                    .map(item -> item.concat(","))
                    .reduce("", String::concat);
            saveFile("[" + reduce + "]");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public static void collecter(File file) {
        try {
            String languageShortForm = file.getName().replace(".json", "");
            String sourse = new String(Files.readAllBytes(Path.of(file.getPath())));
            JSONArray jsonArray = new JSONArray(sourse);
            jsonArray.forEach(item -> {
                JSONObject ff = (JSONObject) item;
                int id = ff.getInt("id");
                Map<String, Object> surah = list.computeIfAbsent(id, key -> list.getOrDefault(key, new LinkedHashMap<>()));
                surah.put("id", id);
                surah.put("name", ff.getString("name"));
                surah.put("transliteration", ff.getString("transliteration"));
                surah.put("translation_" + languageShortForm, ff.getString("translation"));
                surah.put("type", ff.getString("type"));
                surah.put("total_verses", ff.getInt("total_verses"));
            });
            System.out.println(languageShortForm + " done");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public static void saveFile(String data) {
        try {
            FileWriter myWriter = new FileWriter("chapters.json");
            myWriter.write(data);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
