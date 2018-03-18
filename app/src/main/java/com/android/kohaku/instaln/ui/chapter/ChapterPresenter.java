package com.android.kohaku.instaln.ui.chapter;

import com.android.kohaku.instaln.data.DataManager;
import com.android.kohaku.instaln.data.Model.Chapter;
import com.android.kohaku.instaln.data.Model.Content;
import com.android.kohaku.instaln.ui.base.BasePresenter;

/**
 * Created by monis.q on 18-03-2018.
 */

public class ChapterPresenter extends BasePresenter<ChapterContract.View>
        implements ChapterContract.Presenter {


    public ChapterPresenter(DataManager dataManager) {
        super(dataManager);
    }

    @Override
    public Chapter getChapter(String novelName, String chapterNumber) {
        return null;
    }

    @Override
    public Chapter getNextChapter(String novelName, String chapterNumber) {
        return null;
    }

    @Override
    public Chapter getPreviousChapter(String novelName, String chapterNumber) {
        return null;
    }

    @Override
    public Content getContent(String chapterUrl) {
        return null;
    }

    @Override
    public void loadContent(Chapter chapter, Content content) {

    }
}
