package com.android.kohaku.instaln.data.network;

import com.android.kohaku.instaln.data.Model.Chapter;
import com.android.kohaku.instaln.utils.JsoupUtils;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AppChapterHelper implements ChapterHelper {

    @Override
    public List<Chapter> getAllChaptersList(String urlString) throws IOException {
        List<Chapter> chapterList = new ArrayList<>();
        String chapterUrl;
        int chapterNumber = 0;

        Elements elements = JsoupUtils.getElements(urlString, "a");

        for (Element chapterElement : elements) {
            chapterUrl = chapterElement.absUrl("href");
            if (chapterUrl.contains(urlString) && !chapterUrl.endsWith("/#")) {
                chapterNumber++;
                chapterList.add(new Chapter(
                        chapterElement.text(),
                        chapterUrl,
                        chapterNumber
                ));
            }
        }
        for (Chapter chapter: chapterList) {
            chapter.setChapterNumber(chapterNumber--);
        }
        return chapterList;
    }


}
