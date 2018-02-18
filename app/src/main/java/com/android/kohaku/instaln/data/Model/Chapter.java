package com.android.kohaku.instaln.data.Model;

import lombok.Data;

/**
 * Created by monis.q on 04-02-2018.
 */

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
