package com.android.kohaku.instaln.ui.chapter;

import android.content.Context;
import android.util.Log;

import com.android.kohaku.instaln.data.DataManager;
import com.android.kohaku.instaln.data.Model.Chapter;
import com.android.kohaku.instaln.data.Model.Content;
import com.android.kohaku.instaln.ui.base.BasePresenter;
import com.android.kohaku.instaln.utils.InstaUtils;

import java.io.IOException;

import io.reactivex.Completable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by monis.q on 18-03-2018.
 */

public class ChapterPresenter extends BasePresenter<ChapterContract.View>
        implements ChapterContract.Presenter {


    private Context mContext;

    public ChapterPresenter(DataManager dataManager, Context context) {
        super(dataManager);
        mContext = context;
    }

    @Override
    public Chapter getChapter(String novelName, String chapterNumber) {
        return getDataManager().readBook(novelName, InstaUtils.urlEncode(chapterNumber));
    }

    @Override
    public Content getContent(String chapterUrl) throws IOException {
        return getDataManager().getContent(chapterUrl);
    }

    @Override
    public void loadContent(String novelName, String chapterNumber) {
        final Chapter[] chapter = new Chapter[1];
        final Content[] content = new Content[1];

        Log.v("monis", "novelName " + novelName + " chapterNumber " + chapterNumber);

        Completable.fromAction(() -> {
            chapter[0] = getChapter(novelName, chapterNumber);
            if(chapter[0] == null) {
                throw new Exception("Chapter is Null" + chapterNumber);
            }
            content[0] = getDataManager().getContentFromDb(chapter[0].getChapterUrl());
            if(content[0] == null && checkInternet(mContext)) {
                    content[0] = getDataManager().getContent(chapter[0].getChapterUrl());
            } else {
                throw new Exception("Internet not Available");
            }
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError(throwable -> Log.e("monis", "loadContent exception", throwable))
                .subscribe(() -> getView().showContent(chapter[0], content[0]));
    }

    @Override
    public void loadNextChapter(String novelName, String chapterNumber) {

    }

    @Override
    public void loadPreviousChapter(String novelName, String chapterNumber) {

    }
}
