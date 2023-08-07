package com.suyo.quran.models.nonAuth.juz;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(title = "Juz Model", name = "Juz Model 2", description = "juz model ")
public class JuzVerse {
    @Schema(title = "Start Verse Number", example = "0", description = "juz model")
    private int start;
    @Schema(title = "End Verse Number", example = "7", description = "juz model")
    private int end;

    public JuzVerse(HashMap<String, Object> map) {
        this.start = (int) map.get("start");
        this.end = (int) map.get("end");
    }
}