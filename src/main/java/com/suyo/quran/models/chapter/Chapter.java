package com.suyo.quran.models.chapter;

import com.suyo.quran.models.Language;
import com.suyo.quran.models.Translation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@ApiModel("Chapter Model")
public class Chapter {
    //    @ApiModelProperty(name = "Index", position = 1, example = "1", notes = "ordinal number")
    private Integer id;

    //    @ApiModelProperty(name = "Name", position = 2, example = "الفاتحة", notes = "chapter name")
    private String name;

    //    @ApiModelProperty(name = "Type", position = 3, example = "manadiya", notes = "Chapter type")
    private String type;

    //    @ApiModelProperty(name = "Total Verses Number", position = 4, example = "7", notes = "Chapter total verses")
    private Integer totalVerses;

    //    @ApiModelProperty(name = "transliteration pronunciation", position = 5, example = "Al-Fatihah", notes = "Transliteration")
    private String transliteration;

    //    @ApiModelProperty(name = "Translation", position = 6, example = "Fotiha", notes = "you should to select language")
    private Object translation;

    public Chapter(HashMap<String, Object> map, Language language) {
        this.id = (Integer) map.get("id");
        this.name = (String) map.get("name");
        this.type = (String) map.get("type");
        this.totalVerses = (Integer) map.get("total_verses");
        this.transliteration = (String) map.get("transliteration");
        this.translation = new Translation((HashMap<String, String>) map.get("translation")).getLanguage(language);
    }
}
