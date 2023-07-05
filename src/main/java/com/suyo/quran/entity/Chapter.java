package com.suyo.quran.entity;

import org.springframework.data.redis.core.RedisHash;

import javax.persistence.Id;

@RedisHash(value = "chapter")
public class Chapter {
    @Id
    private Short id;
    private String type;
    private String transliteration;
    private Short total_verses;
    private String name;
    private Object translation;

    public Chapter() {
    }

    public Chapter(Short id, String type, String transliteration, Short total_verses, String name, Translation translation) {
        this.id = id;
        this.type = type;
        this.transliteration = transliteration;
        this.total_verses = total_verses;
        this.name = name;
        this.translation = translation;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTransliteration() {
        return transliteration;
    }

    public void setTransliteration(String transliteration) {
        this.transliteration = transliteration;
    }

    public Short getTotal_verses() {
        return total_verses;
    }

    public void setTotal_verses(Short total_verses) {
        this.total_verses = total_verses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getTranslation() {
        return translation;
    }

    public void setTranslation(Translation translation) {
        this.translation = translation;
    }
}
