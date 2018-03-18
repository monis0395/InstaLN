package com.android.kohaku.instaln.ui.chapter;

import com.android.kohaku.instaln.data.Model.Chapter;
import com.android.kohaku.instaln.data.Model.Content;
import com.android.kohaku.instaln.ui.base.BaseContract;

/**
 * Created by monis.q on 18-03-2018.
 */

public class ChapterContract {
    interface View extends BaseContract.View {
        void showContent(Chapter chapter, Content content);
        void loadNextChapter(Chapter chapter);
        void loadPreviousChapter(Chapter chapter);
    }

    interface Presenter extends BaseContract.Presenter<View> {
        Chapter getChapter(String novelName, String chapterNumber);
        Chapter getNextChapter(String novelName, String chapterNumber);
        Chapter getPreviousChapter(String novelName, String chapterNumber);
        void loadContent(Chapter chapter);
    }
}
