package com.android.kohaku.instaln.ui.novelList;

import com.android.kohaku.instaln.data.Model.Novel;
import com.android.kohaku.instaln.ui.base.BaseContract;

import java.util.List;

/**
 * Created by monis.q on 04-03-2018.
 */

public interface NovelListContract {
    interface View extends BaseContract.View {
        void showNovels(List<Novel> novelList);

        void novelClicked(Novel novel);
    }

    interface Presenter extends BaseContract.Presenter<View> {
        void loadNovels();

        void addNovel(final String novelName, final String novelUrl);

    }

}
