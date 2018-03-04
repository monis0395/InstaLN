package com.android.kohaku.instaln.ui.NovelList;

import com.android.kohaku.instaln.data.DataManager;
import com.android.kohaku.instaln.ui.base.BaseActivity;
import com.android.kohaku.instaln.ui.base.BaseContract;
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

    @Override
    public NovelListContract.View getView() {
        return null;
    }

    @Override
    public void onAttach(NovelListContract.View mvpView) {

    }

    @Override
    public void onDetach() {

    }
}
