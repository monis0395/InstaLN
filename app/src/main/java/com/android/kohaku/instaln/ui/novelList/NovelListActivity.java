package com.android.kohaku.instaln.ui.novelList;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.android.kohaku.instaln.R;
import com.android.kohaku.instaln.data.Model.Novel;
import com.android.kohaku.instaln.ui.base.BaseActivity;
import com.mindorks.placeholderview.PlaceHolderView;

import java.util.List;

/**
 * Created by monis.q on 04-03-2018.
 */

public class NovelListActivity extends BaseActivity<NovelListPresenter>
        implements NovelListContract.View {

    PlaceHolderView mNovelView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitvit_novel_list_layout);
        mNovelView = (PlaceHolderView) findViewById(R.id.novelView);
        mPresenter.loadNovels();
    }

    @Override
    public void showNovels(List<Novel> novelList) {
        for (Novel novel: novelList) {
            mNovelView.addView(new NovelItem(this, novel));
        }
    }

    @Override
    protected NovelListPresenter createPresent() {
        return new NovelListPresenter(getDataManager());
    }
}
