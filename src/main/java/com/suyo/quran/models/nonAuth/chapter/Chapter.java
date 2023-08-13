package com.suyo.quran.models.nonAuth.chapter;

import com.suyo.quran.entities.enums.Language;
import com.suyo.quran.entities.Translation;
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

    @Schema(title = "Chapter Title", example = "الفاتحة", description = "Chapter name In Arabic")
    private String title;

    @Schema(title = "Chapter Name", example = "Al-Fatiha", description = "Chapter name In English")
    private String name;

    @Schema(title = "Chapter Type", example = "Makkiyah", description = "Chapter Type")
    private String type;

    @Schema(title = "Chapter Total Verses", example = "7", description = "Chapter total verses")
    private Integer totalVerses;

    @Schema(title = "Translation", example = "{ \"ru\": \"Открывающая Коран\", \"sv\": \"Öppningen\", \"uz\": \"Fotiha\", \"en\": \"The Opener\", \"id\": \"Pembukaan\", \"fr\": \"L'ouverture\", \"bn\": \"সূচনা\", \"ur\": \"کھولنے والی\", \"tr\": \"Fâtiha\", \"es\": \"La Apertura\", \"zh\": \"开端章\"}", description = "Chapter Type")
    private Object translation;

    public Chapter(HashMap<String, Object> map, Language language) {
        this.id = (Integer) map.get("id");
        this.title = StringUtils.newStringUtf8(((String) map.get("title")).getBytes());
        this.name = StringUtils.newStringUtf8(((String) map.get("name")).getBytes());
        this.type = StringUtils.newStringUtf8(((String) map.get("type")).getBytes());
        this.totalVerses = (Integer) map.get("total_verses");
        this.translation = new Translation((HashMap<String, String>) map.get("translation")).getLanguage(language);
    }
}
