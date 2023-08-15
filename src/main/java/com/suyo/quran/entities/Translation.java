package com.suyo.quran.entities;

import com.suyo.quran.entities.enums.Language;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.apache.tomcat.util.codec.binary.StringUtils;

import java.util.HashMap;
import java.util.TreeMap;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "translation")
@Schema(name = "Translation Model", description = "to`ldirib yozish kerak")
public class Translation extends AbsNameEntity {
    @NotNull
    private String ru;
    @NotNull
    private String sv;
    @NotNull
    private String uz;
    @NotNull
    private String en;
    @NotNull
    private String id;
    @NotNull
    private String fr;
    @NotNull
    private String bn;
    @NotNull
    private String ur;
    @NotNull
    private String tr;
    @NotNull
    private String es;
    @NotNull
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
            default -> new TreeMap<String, String>() {{
                put("bn", bn);
                put("en", en);
                put("es", es);
                put("fr", fr);
                put("id", id);
                put("ru", ru);
                put("sv", sv);
                put("tr", tr);
                put("ur", ur);
                put("uz", uz);
                put("zh", zh);
            }};
        };
    }
}
