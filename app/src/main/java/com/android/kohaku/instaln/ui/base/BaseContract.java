package com.android.kohaku.instaln.ui.base;

import android.support.annotation.StringRes;

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
    }

    interface Presenter<V extends View> {

        V getView();

        void onAttach(V mvpView);

        void onDetach();
    }


}
