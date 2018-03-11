package com.android.kohaku.instaln.ui.novel;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.widget.TextView;

import com.android.kohaku.instaln.R;
import com.android.kohaku.instaln.data.AppDataManager;
import com.android.kohaku.instaln.data.Model.Chapter;
import com.android.kohaku.instaln.data.Model.Novel;
import com.android.kohaku.instaln.ui.base.BaseActivity;
import com.mindorks.placeholderview.annotations.View;

import net.the4thdimension.android.Utils;

import java.util.List;
public class NovelActivity extends BaseActivity<NovelPresenter> implements NovelContract.View {


    @View(R.id.novelName)
    TextView novelNameTxt;

    @View(R.id.summaryDetails)
    TextView summaryDetailsTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novel);
        String novelName = getIntent().getStringExtra("novel");
        Novel novel = getDataManager().readBook(AppDataManager.NOVEL_BOOK, novelName);

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
