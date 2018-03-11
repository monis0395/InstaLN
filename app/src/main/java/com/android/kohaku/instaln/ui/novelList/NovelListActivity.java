package com.android.kohaku.instaln.ui.novelList;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.android.kohaku.instaln.ui.base.BaseActivity;

/**
 * Created by monis.q on 04-03-2018.
 */

public class NovelListActivity extends BaseActivity<NovelListPresenter>
        implements NovelListContract.View {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void showNovels() {

    }

    @Override
    protected NovelListPresenter createPresent() {
        return new NovelListPresenter(getDataManager());
    }
}
