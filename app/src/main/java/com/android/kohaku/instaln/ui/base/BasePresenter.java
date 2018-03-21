package com.android.kohaku.instaln.ui.base;

import android.content.Context;
import android.util.Log;

import com.android.kohaku.instaln.data.DataManager;

import net.the4thdimension.android.Utils;

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

    public boolean checkInternet(Context context) {
        boolean isInternetAvailable = Utils.isInternetAvailable(context);
        if(!isInternetAvailable) {
            Log.i("monis", "Internet is not Available");
        }
        return isInternetAvailable;
    }

    @Override
    public DataManager getDataManager() {
        return mDataManager;
    }
}
