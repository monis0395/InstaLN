package com.android.kohaku.instaln.ui.chapter;

import com.android.kohaku.instaln.data.Model.Chapter;
import com.android.kohaku.instaln.data.Model.Content;
import com.android.kohaku.instaln.ui.base.BaseContract;

/**
 * Created by monis.q on 18-03-2018.
 */

public interface ChapterContract {
    interface View extends BaseContract.View {
        void showContent(Chapter chapter, Content content);
        void loadNextChapter(Chapter chapter);
        void loadPreviousChapter(Chapter chapter);
    }

    interface Presenter extends BaseContract.Presenter<View> {
        Chapter getChapter(String novelName, String chapterNumber);
        Content getContent(String chapterUrl);
        void loadContent(Chapter chapter, Content content);
        void loadNextChapter(String novelName, String chapterNumber);
        void loadPreviousChapter(String novelName, String chapterNumber);
    }
}
