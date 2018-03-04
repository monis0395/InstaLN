package com.android.kohaku.instaln.ui.base;

import com.android.kohaku.instaln.data.DataManager;

/**
 * Created by monis.q on 04-03-2018.
 */

public class BasePresenter<V extends BaseContract.View>
        implements BaseContract.Presenter<V> {

    private final DataManager mDataManager;
    private V mMvpView;

    public BasePresenter(DataManager dataManager) {
        mDataManager = dataManager;
    }


    @Override
    public V getView() {
        return mMvpView;
    }

    @Override
    public void onAttach(V mvpView) {
        mMvpView = mvpView;
    }

    @Override
    public void onDetach() {
        mMvpView = null;
    }

    @Override
    public DataManager getDataManager() {
        return mDataManager;
    }
}
