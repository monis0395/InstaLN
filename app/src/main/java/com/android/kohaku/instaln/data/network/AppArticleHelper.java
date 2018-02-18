package com.android.kohaku.instaln.data.network;

import com.android.kohaku.instaln.data.Model.Chapter;
import com.android.kohaku.instaln.data.Model.Content;
import com.android.kohaku.instaln.utils.JsoupUtils;
import com.chimbori.crux.articles.Article;
import com.chimbori.crux.articles.ArticleExtractor;

import org.androidannotations.annotations.Background;

import java.io.IOException;

/**
 * Created by monis.q on 04-02-2018.
 */

public class AppArticleHelper implements ArticleHelper {

    @Background
    @Override
    public Content getContent(Chapter chapter) throws IOException {
        String rawHtml = JsoupUtils.getRawHtml(chapter.getChapterUrl());
        Article article = ArticleExtractor.with(chapter.getChapterUrl(), rawHtml).extractContent().extractMetadata().article();

        return new Content(
                article.title,
                article.document.text(),
                article.document
        );
    }



}