package com.android.kohaku.instaln.ui.novel;

import com.android.kohaku.instaln.data.Model.Chapter;
import com.android.kohaku.instaln.data.Model.Novel;
import com.android.kohaku.instaln.ui.base.BaseContract;

import java.util.List;

/**
 * Created by monis.q on 11-03-2018.
 */

public interface NovelContract {
    interface View extends BaseContract.View {
        void showChapters(List<Chapter> chapterList);
        void chapterClicked(Chapter chapter);
        void refreshChapters();
    }

    interface Presenter extends BaseContract.Presenter<View> {
        Novel getNovel(String novelName);
        void loadChapters(Novel novel);
        void updateChapters(Novel novel);
    }
}
