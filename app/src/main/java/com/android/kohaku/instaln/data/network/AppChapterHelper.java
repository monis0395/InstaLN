package com.android.kohaku.instaln.data.network;

import com.android.kohaku.instaln.data.Model.Chapter;
import com.android.kohaku.instaln.utils.JsoupUtils;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class AppChapterHelper implements ChapterHelper {


    @Override
    public List<Chapter> getAllChaptersList(String urlString) throws IOException {
        List<Chapter> chapterList = Collections.emptyList();
        Chapter chapter;
        String chapterUrl;
        int chapterNumber = 0;

        Elements elements = JsoupUtils.getElements(urlString, "a");

        for (Element chapterElement : elements) {
            chapterUrl = chapterElement.absUrl("href");
            chapterNumber++;
            if (chapterUrl.contains(urlString)) {
                chapter = new Chapter(
                        chapterElement.text(),
                        chapterUrl,
                        chapterNumber
                );

                chapterList.add(chapter);
            }
        }

        return chapterList;
    }


}
