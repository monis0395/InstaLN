package com.android.kohaku.instaln.data.network;

import com.android.kohaku.instaln.data.Model.Chapter;
import com.android.kohaku.instaln.data.Model.Novel;
import com.android.kohaku.instaln.utils.JsoupUtils;

import org.androidannotations.annotations.Background;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

/**
 * Created by monis.q on 04-02-2018.
 */

public class AppChapterHelper implements ChapterHelper {


    @Background
    @Override
    public List<Chapter> getAllChaptersList(Novel novel) throws IOException {
        List<Chapter> chapterList = Collections.emptyList();
        Chapter chapter;
        String chapterUrl;
        int chapterNumber = 0;

        String novelUrlString = novel.getNovelUrl();
        Elements elements = JsoupUtils.getElements(novelUrlString, "a");

        for (Element chapterElement : elements) {
            chapterUrl = chapterElement.absUrl("href");
            chapterNumber++;
            if (chapterUrl.contains(novelUrlString)) {
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
