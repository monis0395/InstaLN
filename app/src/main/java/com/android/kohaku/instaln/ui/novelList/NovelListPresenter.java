package com.android.kohaku.instaln.ui.novelList;

import com.android.kohaku.instaln.data.DataManager;
import com.android.kohaku.instaln.ui.base.BasePresenter;

/**
 * Created by monis.q on 04-03-2018.
 */

public class NovelListPresenter extends BasePresenter<NovelListContract.View>
    implements NovelListContract.Presenter {

    public NovelListPresenter(DataManager dataManager) {
        super(dataManager);
    }

    @Override
    public void loadNovels() {

    }

    @Override
    public void addNovel() {

    }
}
