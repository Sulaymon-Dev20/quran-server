package com.suyo.quran.models.chapter;

import com.suyo.quran.models.Language;
import com.suyo.quran.models.Translation;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(title = "Chapter", name = "Chapter Model", description = "get Chapter list api")
public class Chapter {
    @Schema(name = "Chapter Index", example = "1", description = "Chapter ordinal number")
    private Integer id;

    @Schema(name = "Chapter Name", example = "الفاتحة", description = "Chapter name")
    private String name;

    @Schema(name = "Chapter Type", example = "Makkiyah", description = "Chapter Type")
    private String type;

    @Schema(name = "Chapter Total Verses", example = "7", description = "Chapter total verses")
    private Integer totalVerses;

    @Schema(name = "Chapter pronunciation", example = "Al-Fatihah", description = "Chapter name transliteration pronunciation")
    private String transliteration;

    @Schema(name = "Translation", example = "{ \"ru\": \"Открывающая Коран\", \"sv\": \"Öppningen\", \"uz\": \"Fotiha\", \"en\": \"The Opener\", \"id\": \"Pembukaan\", \"fr\": \"L'ouverture\", \"bn\": \"সূচনা\", \"ur\": \"کھولنے والی\", \"tr\": \"Fâtiha\", \"es\": \"La Apertura\", \"zh\": \"开端章\"}", description = "Chapter Type")
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
