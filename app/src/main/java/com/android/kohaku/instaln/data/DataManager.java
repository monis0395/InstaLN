package com.android.kohaku.instaln.data;

import com.android.kohaku.instaln.data.Model.Chapter;
import com.android.kohaku.instaln.data.Model.Novel;
import com.android.kohaku.instaln.data.database.PaperDB;
import com.android.kohaku.instaln.data.network.ArticleHelper;
import com.android.kohaku.instaln.data.network.ChapterHelper;

import java.io.IOException;
import java.util.List;

/**
 * Created by monis.q on 04-02-2018.
 */

public interface DataManager extends ArticleHelper, ChapterHelper, PaperDB {

    public void writeChapters(String chapterBookName, List<Chapter> chapterList);

    public Novel addNovel(String novelName, String urlString) throws IOException;

    public List<Novel> getAllNovel();

}
