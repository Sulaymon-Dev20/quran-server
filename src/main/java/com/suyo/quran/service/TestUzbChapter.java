package com.suyo.quran.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.TreeMap;

public class TestUzbChapter {

    @SneakyThrows
    public static void main(String[] args) {
        String[] split = Files.readString(Path.of("holyBook.txt")).split("\n");
        TreeMap<Integer, LinkedList<Object>> res = new TreeMap<>();
        for (int i = 0, count = 1, chapter = 0; i < split.length; i++, count++) {
            String s = split[i];
            if (s.startsWith("Chapter")) {
                count = 0;
                chapter++;
            } else {
                LinkedList<Object> surah = res.computeIfAbsent(chapter, value -> new LinkedList<>());
//                surah.addLast(Map.of("chapter", chapter, "verse", count, "text", s.replace(String.valueOf(count), "").replace("\r", "")));
                LinkedHashMap<Object, Object> ayat = new LinkedHashMap<>();
                ayat.put("chapter", chapter);
                ayat.put("verse", count);
                ayat.put("text", s.replace(String.valueOf(count), "").replace("\r", ""));
                surah.addLast(ayat);
            }
        }
        Files.writeString(Path.of("uz2.json"), new ObjectMapper().writeValueAsString(res), StandardCharsets.UTF_8);
    }

    private static String convertToLatin(String text) {
        return text
                .replace("Ё", "YO")
                .replace("Ч", "CH")
                .replace("Ш", "SH")
                .replace("Ю", "YU")
                .replace("Я", "YA")
                .replace("Ў", "O`")
                .replace("Ў", "O'")
                .replace("Ғ", "G`")
                .replace("Ғ", "G'")
                .replace('А', 'A')
                .replace('Б', 'B')
                .replace('В', 'V')
                .replace('Г', 'G')
                .replace('Д', 'D')
                .replace('Е', 'E')
                .replace('Ж', 'J')
                .replace('З', 'Z')
                .replace('И', 'I')
                .replace('Й', 'Y')
                .replace('К', 'K')
                .replace('Л', 'L')
                .replace('М', 'M')
                .replace('Н', 'N')
                .replace('О', 'O')
                .replace('П', 'P')
                .replace('Р', 'R')
                .replace('С', 'S')
                .replace('Т', 'T')
                .replace('У', 'U')
                .replace('Ф', 'F')
                .replace('Х', 'X')
                .replace('Ц', 'S')
                .replace('Э', 'E')
                .replace('Қ', 'Q')
                .replace('Ҳ', 'X')

                .replace("ё", "yo")
                .replace("ч", "ch")
                .replace("ш", "sh")
                .replace("щ", "sh")
                .replace("ю", "yu")
                .replace("я", "ya")
                .replace("ў", "o`")
                .replace("ў", "o'")
                .replace("ғ", "g`")
                .replace("ғ", "g'")
                .replace('а', 'a')
                .replace('б', 'b')
                .replace('в', 'v')
                .replace('г', 'g')
                .replace('д', 'd')
                .replace('е', 'e')
                .replace('ж', 'j')
                .replace('з', 'z')
                .replace('и', 'i')
                .replace('й', 'y')
                .replace('к', 'k')
                .replace('л', 'l')
                .replace('м', 'm')
                .replace('н', 'n')
                .replace('о', 'o')
                .replace('п', 'p')
                .replace('р', 'r')
                .replace('с', 's')
                .replace('т', 't')
                .replace('у', 'u')
                .replace('ф', 'f')
                .replace('х', 'x')
                .replace('ц', 's')
                .replace('э', 'e')
                .replace('қ', 'q')
                .replace('ҳ', 'x');
    }
}