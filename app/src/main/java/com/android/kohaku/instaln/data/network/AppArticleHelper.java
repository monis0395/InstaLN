package com.android.kohaku.instaln.data.network;

import com.android.kohaku.instaln.data.Model.Content;
import com.android.kohaku.instaln.utils.JsoupUtils;
import com.chimbori.crux.articles.Article;
import com.chimbori.crux.articles.ArticleExtractor;

import java.io.IOException;

public class AppArticleHelper implements ArticleHelper {

    @Override
    public Content getContent(String contentUrl) throws IOException {
        String rawHtml = JsoupUtils.getRawHtml(contentUrl);
        Article article = ArticleExtractor.with(contentUrl, rawHtml).extractContent().extractMetadata().article();

        return new Content(
                article.title,
                article.document.toString()
        );
    }



}
