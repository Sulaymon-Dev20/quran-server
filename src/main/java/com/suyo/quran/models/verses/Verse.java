package com.suyo.quran.models.verses;

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
@Schema(title = "Verse Model Verse Model", name = "Verse Model", description = " 2 asdfVerse Model")
public class Verse {
    @Schema(title = "Chapter Number", example = "1", description = "First Chapter")
    private Integer chapter;
    @Schema(title = "Verse Number", example = "1", description = "Number of Verse")
    private Integer verse;
    @Schema(title = "Text", example = "بِسۡمِ ٱللَّهِ ٱلرَّحۡمَٰنِ ٱلرَّحِيمِ", description = "Verse value")
    private String text;
    @Schema(title = "Translation", example = "{" +
            " \"bn\": \"শুরু করছি আল্লাহর নামে যিনি পরম করুণাময়, অতি দয়ালু।\"," +
            " \"en\": \"In the name of Allah, the Entirely Merciful, the Especially Merciful\"," +
            " \"es\": \"En el nombre de Dios, el Compasivo con toda la creación, el Misericordioso con los creyentes\"," +
            " \"fr\": \"Au nom d'Allah, le Tout Miséricordieux, le Très Miséricordieux\"," +
            " \"id\": \"Dengan nama Allah Yang Maha Pengasih, Maha Penyayang\"," +
            " \"ru\": \"Во имя Аллаха, Милостивого, Милосердного\"," +
            " \"sv\": \"I GUDS, DEN NÅDERIKES, DEN BARMHÄRTIGES NAMN\"," +
            " \"tr\": \"Rahman ve Rahim olan Allah'ın adıyla\"," +
            " \"ur\": \"اللہ کے نام سے جو رحمان و رحیم ہے\"," +
            " \"uz\": \"Меҳрибон ва раҳмли Аллоҳнинг номи билан бошлайман. (Аллоҳ таоло ўз китобини 'бисмиллаҳ' билан бошлагани мусулмонларга ҳам ўрнак, улар ҳам доим ўз сўзларини ва ишларини 'бисмиллаҳ' билан бошламоқлари лозим. Пайғамбар алайҳиссалом ҳадисларидан бирида: 'Эътиборли ҳар бир иш 'бисмиллаҳ' билан бошланмас экан, унинг охири кесикдир', деганлар. Яъни, баракаси бўлмайди, охирига етмайди.)\"," +
            " \"zh\": \"奉至仁至慈的安拉之名\"" +
            " }", description = "you can take language")
    private Object translation;

    public Verse(HashMap<String, Object> map, Language language) {
        this.chapter = (int) map.get("chapter");
        this.verse = (int) map.get("verse");
        this.text = (String) map.get("text");
        this.translation = new Translation((HashMap<String, String>) map.get("translation")).getLanguage(language);
    }
}
