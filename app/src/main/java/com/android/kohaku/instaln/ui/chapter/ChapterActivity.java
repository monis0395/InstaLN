package com.android.kohaku.instaln.ui.chapter;

import android.os.Bundle;

import com.android.kohaku.instaln.R;
import com.android.kohaku.instaln.data.Model.Chapter;
import com.android.kohaku.instaln.data.Model.Content;
import com.android.kohaku.instaln.ui.base.BaseActivity;

public class ChapterActivity extends BaseActivity<ChapterPresenter> implements ChapterContract.View {

    protected ChapterPresenter mPresenter;
    protected Chapter mChapter;
    protected Content mContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter);

        mPresenter = createPresent();
        mPresenter.onAttach(this);

        setUp();
    }

    private void setUp() {
        String novelName = getIntent().getStringExtra("novelName");
        String chapterNumber = getIntent().getStringExtra("chapterNumber");
        mChapter = mPresenter.getChapter(novelName, chapterNumber);
        mContent =mPresenter.getContent(mChapter.getChapterUrl());

        mPresenter.loadContent(mChapter, mContent);
    }

    @Override
    public void showContent(Chapter chapter, Content content) {

    }

    @Override
    public void loadNextChapter(Chapter chapter) {

    }

    @Override
    public void loadPreviousChapter(Chapter chapter) {

    }

    @Override
    protected ChapterPresenter createPresent() {
        return new ChapterPresenter(getDataManager());
    }
}
