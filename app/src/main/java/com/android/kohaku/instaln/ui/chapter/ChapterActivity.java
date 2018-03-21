package com.android.kohaku.instaln.ui.chapter;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.Html;
import android.text.Spanned;
import android.widget.TextView;

import com.android.kohaku.instaln.R;
import com.android.kohaku.instaln.data.Model.Chapter;
import com.android.kohaku.instaln.data.Model.Content;
import com.android.kohaku.instaln.ui.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ChapterActivity extends BaseActivity<ChapterPresenter> implements ChapterContract.View {

    @BindView(R.id.chapterName)
    TextView chapterNameTxt;

    @BindView(R.id.contentTxt)
    TextView contentTxt;

    protected ChapterPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter);
        setUnBinder(ButterKnife.bind(this));
        mPresenter = createPresent();
        mPresenter.onAttach(this);

        setUp();
    }

    private void setUp() {
        String novelName = getIntent().getStringExtra("novelName");
        String chapterNumber = getIntent().getStringExtra("chapterNumber");

        mPresenter.loadContent(novelName, chapterNumber);
    }

    @Override
    public void showContent(@NonNull Chapter chapter, @NonNull Content content) {
        chapterNameTxt.setText(chapter.getChapterName());

        Spanned spanned = Html.fromHtml(content.getContent(), Html.FROM_HTML_MODE_COMPACT);
        contentTxt.setText(spanned);
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
