package com.suyo.quran.models.data.JuzChapterModel;

import com.suyo.quran.models.Language;
import com.suyo.quran.models.data.JuzModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "Chapter Model", parent = JuzModel.class, description = "chapter asdf")
public class Chapter {
    @ApiModelProperty(name = "Chapter Number", position = 1, example = "1", notes = "1")
    private int index;
    @ApiModelProperty(name = "Verse", position = 3, example = "1", notes = "verse")
    private JuzVerse verse;
    @ApiModelProperty(name = "type", position = 4, example = "makkiy", notes = "type only be makkiy or manakiy")
    private String type;
    @ApiModelProperty(name = "Surah name", position = 5, example = "Al-Fatiha", notes = "Al-Fatiha")
    private String title;
    @ApiModelProperty(name = "Translation", position = 6, example = "1", notes = "asdffjskajfk")
    private Object translation;

    public Chapter(HashMap<String, Object> map, Language language) {
        this.index = (int) map.get("index");
        this.verse = new JuzVerse((HashMap<String, Object>) map.get("verse"));
        this.type = (String) map.get("type");
        this.title = (String) map.get("title");
        this.translation = new Translation((HashMap<String, String>) map.get("translation")).getLanguage(language);
    }
}
