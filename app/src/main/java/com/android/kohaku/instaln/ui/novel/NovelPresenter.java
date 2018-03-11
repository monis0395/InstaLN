package com.android.kohaku.instaln.ui.novel;

import com.android.kohaku.instaln.data.DataManager;
import com.android.kohaku.instaln.data.Model.Novel;
import com.android.kohaku.instaln.ui.base.BasePresenter;

/**
 * Created by monis.q on 11-03-2018.
 */

public class NovelPresenter extends BasePresenter<NovelContract.View>
        implements NovelContract.Presenter {
    public NovelPresenter(DataManager dataManager) {
        super(dataManager);
    }

    @Override
    public void loadChapters(Novel novel) {

    }

    @Override
    public void updateChapters(Novel novel) {

    }
}
