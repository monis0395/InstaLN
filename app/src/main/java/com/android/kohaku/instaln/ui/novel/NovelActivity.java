package com.android.kohaku.instaln.ui.novel;

import android.content.Intent;
import android.os.Bundle;

import com.android.kohaku.instaln.R;
import com.android.kohaku.instaln.data.Model.Chapter;
import com.android.kohaku.instaln.data.Model.Novel;
import com.android.kohaku.instaln.ui.base.BaseActivity;
import com.android.kohaku.instaln.ui.chapter.ChapterActivity;
import com.android.kohaku.instaln.ui.novel.model.ChapterListItem;
import com.android.kohaku.instaln.ui.novel.model.NovelDetailsItem;
import com.mindorks.placeholderview.PlaceHolderView;

import java.util.List;

public class NovelActivity extends BaseActivity<NovelPresenter> implements NovelContract.View {

    String novelName;
    Novel novel;

    PlaceHolderView mChaptersListView;
    protected NovelPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novel);
        mChaptersListView = findViewById(R.id.chaptersListView);

        mPresenter = createPresent();
        mPresenter.onAttach(this);

        setUp();
    }

    private void setUp() {
        novelName = getIntent().getStringExtra("novelName");
        novel = mPresenter.getNovel(novelName);

        mPresenter.loadChapters(novel);
    }

    @Override
    public void showChapters(List<Chapter> chapterList) {
        mChaptersListView.removeAllViews();

        mChaptersListView.addView(new NovelDetailsItem(this, novel));

        for (Chapter chapter : chapterList) {
            mChaptersListView.addView(new ChapterListItem(this, chapter));
        }
    }

    @Override
    public void refreshChapters() {

    }

    @Override
    public void chapterClicked(Chapter chapter) {
        String chapterNumber = String.valueOf(chapter.getChapterNumber());

        Intent i = new Intent(this, ChapterActivity.class);
        i.putExtra("novelName", novelName);
        i.putExtra("chapterNumber", chapterNumber);
        startActivity(i);
    }

    @Override
    protected NovelPresenter createPresent() {
        return new NovelPresenter(getDataManager(), this);
    }

    @Override
    protected void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }
}
