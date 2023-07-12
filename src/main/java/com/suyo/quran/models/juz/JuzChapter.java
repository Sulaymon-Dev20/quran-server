package com.suyo.quran.models.juz;

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
@Schema(title = "Juz Chapter Model", name = "Chapter Juz Model", description = "chapter asdf")
public class JuzChapter {
    @Schema(name = "Chapter Number", example = "1", description = "First Chapter")
    private int index;
    @Schema(name = "Chapter type", example = "makkiy", description = "type only be makkiy or manakiy")
    private String type;
    @Schema(name = "Chapter name", example = "الفاتحة", description = "chat chapter name only arabic")
    private String title;
    @Schema(name = "Chapter Translation name", example = "{ \"ru\": \"Открывающая Коран\", \"sv\": \"Öppningen\", \"uz\": \"Fotiha\", \"en\": \"The Opener\", \"id\": \"Pembukaan\", \"fr\": \"L'ouverture\", \"bn\": \"সূচনা\", \"ur\": \"کھولنے والی\", \"tr\": \"Fâtiha\", \"es\": \"La Apertura\", \"zh\": \"开端章\"}", description = "Chapter translation all language")
    private Object translation;
    @Schema(name = "Chapter Verse", example = "{\"start\": 1,\"end\": 7}", description = "verse")
    private JuzVerse verse;

    public JuzChapter(HashMap<String, Object> map, Language language) {
        this.index = (int) map.get("index");
        this.verse = new JuzVerse((HashMap<String, Object>) map.get("verse"));
        this.type = (String) map.get("type");
        this.title = (String) map.get("title");
        this.translation = new Translation((HashMap<String, String>) map.get("translation")).getLanguage(language);
    }
}
