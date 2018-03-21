package com.android.kohaku.instaln.ui.novel;

import android.util.Log;

import com.android.kohaku.instaln.data.DataManager;
import com.android.kohaku.instaln.data.Model.Chapter;
import com.android.kohaku.instaln.data.Model.Novel;
import com.android.kohaku.instaln.ui.base.BasePresenter;
import com.android.kohaku.instaln.utils.InstaUtils;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Action;
import io.reactivex.schedulers.Schedulers;

import static com.android.kohaku.instaln.data.database.PaperDB.NOVEL_BOOK;

/**
 * Created by monis.q on 11-03-2018.
 */

public class NovelPresenter extends BasePresenter<NovelContract.View>
        implements NovelContract.Presenter {
    public NovelPresenter(DataManager dataManager) {
        super(dataManager);
    }

    @Override
    public Novel getNovel(String novelName) {
        return getDataManager().readBook(NOVEL_BOOK, InstaUtils.urlEncode(novelName));
    }

    @Override
    public void loadChapters(Novel novel) {
        Single.fromCallable(() -> getDataManager().updateChapters(novel))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError(throwable -> Log.e("monis", "loadChapters exception", throwable))
                .subscribe(chaptersList -> getView().showChapters(chaptersList));
    }

    @Override
    public void updateChapters(Novel novel) {
        Completable.fromAction(() -> getDataManager().updateChapters(novel))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError(throwable -> Log.e("monis", "updateChapters exception", throwable))
                .subscribe(() -> loadChapters(novel));
    }
}
