package com.android.kohaku.instaln.data.Model;

import org.jsoup.nodes.Document;

import lombok.Data;

@Data
public class Content {

    public Content(String title, String content, Document document) {
        this.title = title;
        this.content = content;
        this.document = document;
    }

    String title;

    String content;

    Document document;

}
