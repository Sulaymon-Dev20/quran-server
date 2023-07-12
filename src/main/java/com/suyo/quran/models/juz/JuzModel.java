package com.suyo.quran.models.juz;

import com.suyo.quran.models.Language;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(title = "Juz Model", name = "Juz Model 2", description = "juz model ")
public class JuzModel {
    @Schema(name = "Index", example = "1", description = "Juz number")
    private int index;
    @Schema(name = "Chapter List", description = "Chapter all info without hole verse")
    private List<JuzChapter> chapters;

    public JuzModel(HashMap<String, Object> map, Language language) {
        this.index = (Integer) map.get("index");
        this.chapters = ((List<HashMap>) map.get("chapters")).stream().map(item -> new JuzChapter(item, language)).toList();
    }
}
