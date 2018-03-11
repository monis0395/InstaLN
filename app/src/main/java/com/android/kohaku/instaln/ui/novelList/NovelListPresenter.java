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
        Log.v("monis", "loadNovels");
        List<Novel> novelList = getDataManager().getAllNovel();
        getView().showNovels(novelList);
//        TinyTask.perform(new Something<List<Novel>>() {
//            @Override
//            public List<Novel> whichDoes() {
//                Log.v("monis", "getAllNovel");
//                return getDataManager().getAllNovel();
//            }
//        }).whenDone(new DoThis<List<Novel>>() {
//            @Override
//            public void ifOK(List<Novel> novelList) {
//                getView().showNovels(novelList);
//            }
//
//            @Override
//            public void ifNotOK(Exception e) {
//                Log.e("monis", "exception", e);
//            }
//        }).go();
    }

    @Override
    public void addNovel(final String novelName, final String novelUrl) {

        TinyTask.perform(new Something<Boolean>() {
            @Override
            public Boolean whichDoes() {
                try {
                    Log.v("monis", "addNovel: " + novelName);
                    getDataManager().addNovel(novelName, novelUrl);
                } catch (IOException e) {
                    Log.e("MYAPP", "exception", e);
                }
                return Boolean.TRUE;
            }
        }).whenDone(new DoThis<Boolean>() {
            @Override
            public void ifOK(Boolean aBoolean) {
                loadNovels();
            }

            @Override
            public void ifNotOK(Exception e) {
                Log.e("MYAPP", "exception", e);
            }
        }).go();

    }
}
