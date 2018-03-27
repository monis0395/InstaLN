package com.android.kohaku.instaln.ui.novelList;

import android.content.Context;
import android.util.Log;

import com.android.kohaku.instaln.data.DataManager;
import com.android.kohaku.instaln.ui.base.BasePresenter;

import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by monis.q on 04-03-2018.
 */

public class NovelListPresenter extends BasePresenter<NovelListContract.View>
        implements NovelListContract.Presenter {

    private Context mContext;

    public NovelListPresenter(DataManager dataManager, Context context) {
        super(dataManager);
        mContext = context;
    }

    @Override
    public void loadNovels() {
        Single.fromCallable(() -> getDataManager().getAllNovel())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError(throwable -> Log.e("monis", "loadNovels exception", throwable))
                .subscribe(novelList -> getView().showNovels(novelList));
    }

    @Override
    public void addNovel(final String novelName, final String novelUrl) {
        if (!checkInternet(mContext)) {
            //todo:show internet not available
            return;
        }
        Completable.fromAction(() -> getDataManager().addNovel(novelName, novelUrl))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError(throwable -> Log.e("monis", "addNovel exception", throwable))
                .subscribe(this::loadNovels);
    }
}
