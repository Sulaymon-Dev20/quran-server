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
    @Schema(title = "firstName", example = "بِسۡمِ ٱللَّهِ ٱلرَّحۡمَٰنِ ٱلرَّحِيمِ", description = "Verse value")
    private String firstName;
    @Schema(title = "lastName", example = "بِسۡمِ ٱللَّهِ ٱلرَّحۡمَٰنِ ٱلرَّحِيمِ", description = "Verse value")
    private String lastName;
    @Schema(title = "email", example = "بِسۡمِ ٱللَّهِ ٱلرَّحۡمَٰنِ ٱلرَّحِيمِ", description = "Verse value")
    private String email;
    @Schema(title = "theme", example = "بِسۡمِ ٱللَّهِ ٱلرَّحۡمَٰنِ ٱلرَّحِيمِ", description = "Verse value")
    private ThemeEnum theme;
    @Schema(title = "bookmarks", example = "بِسۡمِ ٱللَّهِ ٱلرَّحۡمَٰنِ ٱلرَّحِيمِ", description = "Verse value")
    private String bookmarks;
    @Schema(title = "textSettings", example = "بِسۡمِ ٱللَّهِ ٱلرَّحۡمَٰنِ ٱلرَّحِيمِ", description = "Verse value")
    private String textSettings;
    @Schema(title = "createdAt", example = "بِسۡمِ ٱللَّهِ ٱلرَّحۡمَٰنِ ٱلرَّحِيمِ", description = "Verse value")
    private Timestamp createdAt;
    @Schema(title = "updatedAt", example = "بِسۡمِ ٱللَّهِ ٱلرَّحۡمَٰنِ ٱلرَّحِيمِ", description = "Verse value")
    private Timestamp updatedAt;
}
