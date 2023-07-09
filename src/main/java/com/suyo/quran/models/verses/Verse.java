package com.suyo.quran.models.verses;

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
@ApiModel(value = "Verse Model", description = "chapter asdf")
public class Verse {
    @ApiModelProperty(name = "Chapter Number", position = 1, example = "1", notes = "First Chapter")
    private Integer chapter;
    @ApiModelProperty(name = "Verse Number", position = 2, example = "1", notes = "Number of Verse")
    private Integer verse;
    @ApiModelProperty(name = "Text", position = 3, example = "بِسۡمِ ٱللَّهِ ٱلرَّحۡمَٰنِ ٱلرَّحِيمِ", notes = "Verse value")
    private String text;
    @ApiModelProperty(name = "Translation", position = 4, example = "\"translation\": {\n" +
        "                \"bn\": \"শুরু করছি আল্লাহর নামে যিনি পরম করুণাময়, অতি দয়ালু।\",\n" +
        "                \"en\": \"In the name of Allah, the Entirely Merciful, the Especially Merciful\",\n" +
        "                \"es\": \"En el nombre de Dios, el Compasivo con toda la creación, el Misericordioso con los creyentes\",\n" +
        "                \"fr\": \"Au nom d'Allah, le Tout Miséricordieux, le Très Miséricordieux\",\n" +
        "                \"id\": \"Dengan nama Allah Yang Maha Pengasih, Maha Penyayang\",\n" +
        "                \"ru\": \"Во имя Аллаха, Милостивого, Милосердного\",\n" +
        "                \"sv\": \"I GUDS, DEN NÅDERIKES, DEN BARMHÄRTIGES NAMN\",\n" +
        "                \"tr\": \"Rahman ve Rahim olan Allah'ın adıyla\",\n" +
        "                \"ur\": \"اللہ کے نام سے جو رحمان و رحیم ہے\",\n" +
        "                \"uz\": \"Меҳрибон ва раҳмли Аллоҳнинг номи билан бошлайман. (Аллоҳ таоло ўз китобини \\\"бисмиллаҳ\\\" билан бошлагани мусулмонларга ҳам ўрнак, улар ҳам доим ўз сўзларини ва ишларини \\\"бисмиллаҳ\\\" билан бошламоқлари лозим. Пайғамбар алайҳиссалом ҳадисларидан бирида: \\\"Эътиборли ҳар бир иш \\\"бисмиллаҳ\\\" билан бошланмас экан, унинг охири кесикдир\\\", деганлар. Яъни, баракаси бўлмайди, охирига етмайди.)\",\n" +
        "                \"zh\": \"奉至仁至慈的安拉之名\"\n" +
        "            }", notes = "1")
    private Object translation;

    public Verse(HashMap<String, Object> map, Language language) {
        this.chapter = (int) map.get("chapter");
        this.verse = (int) map.get("verse");
        this.text = (String) map.get("text");
        this.translation = new Translation((HashMap<String, String>) map.get("translation")).getLanguage(language);
    }
}
