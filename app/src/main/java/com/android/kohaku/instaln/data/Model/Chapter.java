package com.android.kohaku.instaln.data.Model;

import lombok.Data;

@Data
public class Chapter {

    public Chapter(String chapterName, String chapterUrl, int chapterNumber) {
        this.chapterName = chapterName;
        this.chapterUrl = chapterUrl;
        this.chapterNumber = chapterNumber;
    }

    String chapterName;

    String chapterUrl;

    int chapterNumber;
}
