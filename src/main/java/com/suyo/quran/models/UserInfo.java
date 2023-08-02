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
@Schema(title = "User Info Model", name = "User Information", description = "there is information of user")
public class UserInfo {
    @Schema(title = "firstName", example = "SulaymonYahyo", description = "Verse value")
    private String firstName;
    @Schema(title = "lastName", example = "Ibn Baxodir", description = "Verse value")
    private String lastName;
    @Schema(title = "email", example = "sulaymon1w@gmail.com", description = "Verse value")
    private String email;
    @Schema(title = "theme", example = "dark", description = "Verse value")
    private ThemeEnum theme;
    @Schema(title = "bookmarks", example = "[12,33,22]", description = "Verse value")
    private String bookmarks;
    @Schema(title = "textSettings", example = "", description = "Verse value")
    private String textSettings;
    @Schema(title = "createdAt", example = "", description = "Verse value")
    private Timestamp createdAt;
    @Schema(title = "updatedAt", example = "", description = "Verse value")
    private Timestamp updatedAt;
}
