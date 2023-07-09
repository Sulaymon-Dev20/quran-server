package com.suyo.quran.models.data;

import com.suyo.quran.models.Language;
import com.suyo.quran.models.data.JuzChapterModel.Chapter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("Juz Model")
public class JuzModel {
    @ApiModelProperty(name = "Index", position = 1, example = "1", notes = "asdffjskajfk")
    private int index;
    @ApiModelProperty(name = "Chapter list", position = 2, example = "[{},{},{}]", notes = "asdffjskajfk")
    private List<Chapter> chapters;

    public JuzModel(HashMap<String, Object> map, Language language) {
        this.index = (Integer) map.get("index");
        this.chapters = ((List<HashMap>) map.get("chapters")).stream().map(item -> new Chapter(item, language)).toList();
    }
}
