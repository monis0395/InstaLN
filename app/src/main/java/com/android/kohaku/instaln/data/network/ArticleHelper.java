package com.android.kohaku.instaln.data.network;

import com.android.kohaku.instaln.data.Model.Content;

import java.io.IOException;

public interface ArticleHelper {

    Content getContent(String contentUrl) throws IOException;
}
