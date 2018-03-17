package com.android.kohaku.instaln.ui.novel;

import android.os.Bundle;
import android.widget.TextView;

import com.android.kohaku.instaln.R;
import com.android.kohaku.instaln.data.Model.Chapter;
import com.android.kohaku.instaln.data.Model.Novel;
import com.android.kohaku.instaln.ui.base.BaseActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NovelActivity extends BaseActivity<NovelPresenter> implements NovelContract.View {

    @BindView(R.id.novelName)
    TextView novelNameTxt;

    @BindView(R.id.summaryDetails)
    TextView summaryDetailsTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novel);
        setUnBinder(ButterKnife.bind(this));

        setUp();
    }

    private void setUp() {
        String novelName = getIntent().getStringExtra("novelName");
        Novel novel = mPresenter.getNovel(novelName);

        novelNameTxt.setText(novel.getNovelName());
        summaryDetailsTxt.setText(novel.getNovelSummary().getContent());
    }

    @Override
    public void showChapters(List<Chapter> chapterList) {

    }

    @Override
    public void refreshChapters() {

    }

    @Override
    public void chapterClicked(Chapter chapter) {

    }

    @Override
    protected NovelPresenter createPresent() {
        return new NovelPresenter(getDataManager());
    }
}
