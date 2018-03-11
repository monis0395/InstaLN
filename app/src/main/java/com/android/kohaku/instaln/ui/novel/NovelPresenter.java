package com.android.kohaku.instaln.ui.novel;

import android.util.Log;

import com.android.kohaku.instaln.data.DataManager;
import com.android.kohaku.instaln.data.Model.Chapter;
import com.android.kohaku.instaln.data.Model.Novel;
import com.android.kohaku.instaln.ui.base.BasePresenter;

import java.io.IOException;
import java.util.List;

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
        List<Chapter> chapters = getDataManager().getAllChapters(novel);
        getView().showChapters(chapters);
    }

    @Override
    public void updateChapters(Novel novel) {
        try {
            getDataManager().updateChapters(novel);
        } catch (IOException e) {
            Log.e("NovelPresenter", "Exception", e);
        }
    }
}
