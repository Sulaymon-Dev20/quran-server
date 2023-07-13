package com.suyo.quran.models.chapter;

import com.suyo.quran.models.Language;
import com.suyo.quran.models.Translation;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.tomcat.util.codec.binary.StringUtils;

import java.util.HashMap;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(title = "Chapter", name = "Chapter Model", description = "get Chapter list api")
public class Chapter {
    @Schema(title = "Chapter Index", example = "1", description = "Chapter ordinal number")
    private Integer id;

    @Schema(title = "Chapter Name", example = "الفاتحة", description = "Chapter name")
    private String name;

    @Schema(title = "Chapter Type", example = "Makkiyah", description = "Chapter Type")
    private String type;

    @Schema(title = "Chapter Total Verses", example = "7", description = "Chapter total verses")
    private Integer totalVerses;

    @Schema(title = "Chapter pronunciation", example = "Al-Fatihah", description = "Chapter name transliteration pronunciation")
    private String transliteration;

    @Schema(title = "Translation", example = "{ \"ru\": \"Открывающая Коран\", \"sv\": \"Öppningen\", \"uz\": \"Fotiha\", \"en\": \"The Opener\", \"id\": \"Pembukaan\", \"fr\": \"L'ouverture\", \"bn\": \"সূচনা\", \"ur\": \"کھولنے والی\", \"tr\": \"Fâtiha\", \"es\": \"La Apertura\", \"zh\": \"开端章\"}", description = "Chapter Type")
    private Object translation;

    public Chapter(HashMap<String, Object> map, Language language) {
        this.id = (Integer) map.get("id");
        this.name = StringUtils.newStringUtf8(((String) map.get("name")).getBytes());
        this.type = StringUtils.newStringUtf8(((String) map.get("type")).getBytes());
        this.totalVerses = (Integer) map.get("total_verses");
        this.transliteration = StringUtils.newStringUtf8(((String) map.get("transliteration")).getBytes());
        this.translation = new Translation((HashMap<String, String>) map.get("translation")).getLanguage(language);
    }
}
