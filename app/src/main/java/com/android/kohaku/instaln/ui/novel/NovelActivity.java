package com.android.kohaku.instaln.ui.novel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.android.kohaku.instaln.R;
import com.android.kohaku.instaln.data.Model.Chapter;
import com.android.kohaku.instaln.ui.base.BaseActivity;

import java.util.List;

public class NovelActivity extends BaseActivity<NovelPresenter> implements NovelContract.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novel);
    }

    @Override
    public void showChapters(List<Chapter> chapterList) {

    }

    @Override
    public void chapterClicked(Chapter chapter) {

    }

    @Override
    public void refreshChapters() {

    }

    @Override
    protected NovelPresenter createPresent() {
        return new NovelPresenter(getDataManager());
    }
}
