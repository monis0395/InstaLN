package com.android.kohaku.instaln.ui.base;

import android.support.annotation.StringRes;

import com.android.kohaku.instaln.data.DataManager;

/**
 * Created by monis.q on 04-03-2018.
 */

public interface BaseContract {

    interface View {

        void showLoading();

        void hideLoading();

        void showMessage(String message);

        void showMessage(@StringRes int resId);

        boolean isNetworkConnected();

        void hideKeyboard();

        DataManager getDataManager();
    }

    interface Presenter<V extends View> {

        V getView();

        void onAttach(V mvpView);

        void onDetach();

        DataManager getDataManager();
    }


}
