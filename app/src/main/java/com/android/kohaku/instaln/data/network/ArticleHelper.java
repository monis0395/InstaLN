package com.android.kohaku.instaln.data.network;

import com.android.kohaku.instaln.data.Model.Chapter;
import com.android.kohaku.instaln.data.Model.Content;

import java.io.IOException;

/**
 * Created by monis.q on 04-02-2018.
 */

public interface ArticleHelper {

    Content getContent(Chapter chapter) throws IOException;
}
