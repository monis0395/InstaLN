package com.android.kohaku.instaln.ui.NovelList;

import com.android.kohaku.instaln.ui.base.BaseContract;

/**
 * Created by monis.q on 04-03-2018.
 */

public class NovelListContract {
    interface View extends BaseContract.View {
        void showNovels();
    }

    interface Presenter extends BaseContract.Presenter<View> {
        void loadNovels();
        void addNovel();
    }

}
