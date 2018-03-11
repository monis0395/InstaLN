package com.android.kohaku.instaln.ui.novelList;

import com.android.kohaku.instaln.data.DataManager;
import com.android.kohaku.instaln.data.Model.Novel;
import com.android.kohaku.instaln.ui.base.BasePresenter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
        List<Novel> novelList = new ArrayList<>();
        novelList.add(new Novel("Overgeared","http://novelplanet.com/Novel/Overgeared"));
        novelList.add(new Novel("Library of Heaven's Path","http://novelplanet.com/Novel/Library-of-Heaven-s-Path"));
        novelList.add(new Novel("The Book Eating Magician","http://novelplanet.com/Novel/The-Book-Eating-Magician"));

        getView().showNovels(novelList);
    }

    @Override
    public void addNovel() {

    }
}
