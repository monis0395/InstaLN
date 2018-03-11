package com.android.kohaku.instaln.ui.novel;

import android.os.Bundle;
import android.widget.TextView;

import com.android.kohaku.instaln.R;
import com.android.kohaku.instaln.data.Model.Chapter;
import com.android.kohaku.instaln.ui.base.BaseActivity;
import com.mindorks.placeholderview.annotations.View;

import java.util.List;

public class NovelActivity extends BaseActivity<NovelPresenter> implements NovelContract.View {


    @View(R.id.novelName)
    TextView novelname;

    @View(R.id.summaryDetails)
    TextView summaryDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novel);
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
