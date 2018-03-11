package com.android.kohaku.instaln.data.Model;

import java.io.Serializable;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Novel implements Serializable {

    public Novel(String novelName, String novelUrl) {
        this.novelName = novelName;
        this.novelUrl = novelUrl;
    }

    String novelName;

    String novelUrl;

    Content novelSummary;
}
