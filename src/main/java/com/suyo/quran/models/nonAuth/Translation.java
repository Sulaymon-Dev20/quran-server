package com.suyo.quran.models.nonAuth;

import com.suyo.quran.entities.enums.Language;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.tomcat.util.codec.binary.StringUtils;

import java.util.HashMap;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "Translation Model", description = "to`ldirib yozish kerak")
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
        this.ru = StringUtils.newStringUtf8(map.get("ru").getBytes());
        this.sv = StringUtils.newStringUtf8(map.get("sv").getBytes());
        this.uz = StringUtils.newStringUtf8(map.get("uz").getBytes());
        this.en = StringUtils.newStringUtf8(map.get("en").getBytes());
        this.id = StringUtils.newStringUtf8(map.get("id").getBytes());
        this.fr = StringUtils.newStringUtf8(map.get("fr").getBytes());
        this.bn = StringUtils.newStringUtf8(map.get("bn").getBytes());
        this.ur = StringUtils.newStringUtf8(map.get("ur").getBytes());
        this.tr = StringUtils.newStringUtf8(map.get("tr").getBytes());
        this.es = StringUtils.newStringUtf8(map.get("es").getBytes());
        this.zh = StringUtils.newStringUtf8(map.get("zh").getBytes());
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
