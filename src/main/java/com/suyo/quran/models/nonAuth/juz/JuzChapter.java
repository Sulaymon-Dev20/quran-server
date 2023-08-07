package com.suyo.quran.models.nonAuth.juz;

import com.suyo.quran.entities.enums.Language;
import com.suyo.quran.models.nonAuth.Translation;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.tomcat.util.codec.binary.StringUtils;

import java.util.HashMap;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(title = "Juz Chapter Model", name = "Chapter Juz Model", description = "chapter asdf")
public class JuzChapter {
    @Schema(title = "Chapter Number", example = "1", description = "First Chapter")
    private int index;
    @Schema(title = "Chapter type", example = "makkiy", description = "type only be makkiy or manakiy")
    private String type;
    @Schema(title = "Chapter name", example = "الفاتحة", description = "chat chapter name only arabic")
    private String title;
    @Schema(title = "Chapter Translation name", example = "{ \"ru\": \"Открывающая Коран\", \"sv\": \"Öppningen\", \"uz\": \"Fotiha\", \"en\": \"The Opener\", \"id\": \"Pembukaan\", \"fr\": \"L'ouverture\", \"bn\": \"সূচনা\", \"ur\": \"کھولنے والی\", \"tr\": \"Fâtiha\", \"es\": \"La Apertura\", \"zh\": \"开端章\"}", description = "Chapter translation all language")
    private Object translation;
    @Schema(title = "Chapter Verse", example = "{\"start\": 1,\"end\": 7}", description = "verse")
    private JuzVerse verse;

    public JuzChapter(HashMap<String, Object> map, Language language) {
        this.index = (int) map.get("index");
        this.verse = new JuzVerse((HashMap<String, Object>) map.get("verse"));
        this.type = StringUtils.newStringUtf8(((String) map.get("type")).getBytes());
        this.title = StringUtils.newStringUtf8(((String) map.get("title")).getBytes());
        this.translation = new Translation((HashMap<String, String>) map.get("translation")).getLanguage(language);
    }
}
