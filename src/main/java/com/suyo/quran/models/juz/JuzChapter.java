package com.suyo.quran.models.juz;

import com.suyo.quran.models.Language;
import com.suyo.quran.models.Translation;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "Juz Chapter Model", parent = JuzModel.class, description = "chapter asdf")
public class JuzChapter {
    @ApiModelProperty(name = "Chapter Number", position = 1, example = "1", notes = "1")
    private int index;
    @ApiModelProperty(name = "type", position = 2, example = "makkiy", notes = "type only be makkiy or manakiy")
    private String type;
    @ApiModelProperty(name = "Surah name", position = 3, example = "Al-Fatiha", notes = "Al-Fatiha")
    private String title;
    @ApiModelProperty(name = "Translation", position = 4, example = "1", notes = "asdffjskajfk")
    private Object translation;
    @ApiModelProperty(name = "Verse", position = 5, example = "1", notes = "verse")
    private JuzVerse verse;
    public JuzChapter(HashMap<String, Object> map, Language language) {
        this.index = (int) map.get("index");
        this.verse = new JuzVerse((HashMap<String, Object>) map.get("verse"));
        this.type = (String) map.get("type");
        this.title = (String) map.get("title");
        this.translation = new Translation((HashMap<String, String>) map.get("translation")).getLanguage(language);
    }
}
