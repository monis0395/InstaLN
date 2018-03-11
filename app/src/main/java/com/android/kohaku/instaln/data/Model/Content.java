package com.android.kohaku.instaln.data.Model;

import org.jsoup.nodes.Document;

import lombok.Data;

@Data
public class Content {

    public Content(String title, String content) {
        this.title = title;
        this.content = content;
    }

    String title;

    String content;


}
