package com.android.kohaku.instaln.ui.novelList;

import android.util.Log;

import com.android.kohaku.instaln.data.DataManager;
import com.android.kohaku.instaln.data.Model.Novel;
import com.android.kohaku.instaln.ui.base.BasePresenter;

import java.io.IOException;
import java.util.List;

import inaka.com.tinytask.DoThis;
import inaka.com.tinytask.Something;
import inaka.com.tinytask.TinyTask;

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
        TinyTask.perform(new Something<List<Novel>>() {
            @Override
            public List<Novel> whichDoes() throws Exception {
                return getDataManager().getAllNovel();
            }
        }).whenDone(new DoThis<List<Novel>>() {
            @Override
            public void ifOK(List<Novel> novelList) {
                getView().showNovels(novelList);
            }
            @Override
            public void ifNotOK(Exception e) {
                Log.e("monis", "exception", e);
            }
        }).go();

    }

    @Override
    public void addNovel() {

        Something<Boolean> something = new Something<Boolean>() {
            @Override
            public Boolean whichDoes() {
                try {
                    getDataManager().addNovel("Overgeared",
                            "http://novelplanet.com/Novel/Overgeared/");
                    getDataManager().addNovel("Library of Heaven's Path",
                            "http://novelplanet.com/Novel/Library-of-Heaven-s-Path");
                    getDataManager().addNovel("The Book Eating Magician",
                            "http://novelplanet.com/Novel/The-Book-Eating-Magician");
                    return Boolean.TRUE;
                } catch (IOException e) {
                    e.printStackTrace();
                    return Boolean.FALSE;
                }
            }
        };

        DoThis<Boolean> doThis = new DoThis<Boolean>() {
            @Override
            public void ifOK(Boolean aBoolean) {
                loadNovels();
            }

            @Override
            public void ifNotOK(Exception e) {
                Log.e("MYAPP", "exception", e);
            }
        };
        getView().showLoading();

        TinyTask.perform(something).whenDone(doThis).go();
        getView().hideLoading();

    }
}
