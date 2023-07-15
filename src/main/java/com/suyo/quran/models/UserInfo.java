package com.suyo.quran.models;

import com.suyo.quran.entities.enums.ThemeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(title = "Verse Model Verse Model", name = "Verse Model", description = "asdf Verse Model")
public class UserInfo {
    private String firstName;
    private String lastName;
    private String email;
    private ThemeEnum theme;
    private String bookmarks;
    private String textSettings;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
