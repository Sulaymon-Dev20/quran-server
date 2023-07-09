package com.suyo.quran.models.data.JuzChapterModel;

import com.suyo.quran.models.Language;
import com.suyo.quran.models.data.JuzModel;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "Translation Model", parent = JuzModel.class, description = "chapter asdf")
public class Translation {
    private String ru;
    private String sv;
    private String uz;
    private String en;
    private String id;
    private String fr;
    private String bn;
    private String ur;
    private String tr;
    private String es;
    private String zh;

    public Translation(HashMap<String, String> map) {
        this.ru = map.get("ru");
        this.sv = map.get("sv");
        this.uz = map.get("uz");
        this.en = map.get("en");
        this.id = map.get("id");
        this.fr = map.get("fr");
        this.bn = map.get("bn");
        this.ur = map.get("ur");
        this.tr = map.get("tr");
        this.es = map.get("es");
        this.zh = map.get("zh");
    }

    public Object getLanguage(Language language) {
        return switch (language) {
            case BN -> this.bn;
            case EN -> this.en;
            case ES -> this.es;
            case FR -> this.fr;
            case ID -> this.id;
            case RU -> this.ru;
            case SV -> this.sv;
            case TR -> this.tr;
            case UR -> this.ur;
            case UZ -> this.uz;
            case ZH -> this.zh;
            default -> this;
        };
    }
}
