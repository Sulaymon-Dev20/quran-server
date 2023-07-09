package com.suyo.quran.models.juz;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "Juz Verse Model", parent = JuzChapter.class)
public class JuzVerse {
    @ApiModelProperty(name = "start Chapter number", position = 1, example = "1", notes = "1")
    private int start;
    @ApiModelProperty(name = "end chaoter number", position = 1, example = "7", notes = "1")
    private int end;

    public JuzVerse(HashMap<String, Object> map) {
        this.start = (int) map.get("start");
        this.end = (int) map.get("end");
    }
}
