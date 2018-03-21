package com.android.kohaku.instaln.ui.novelList;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.android.kohaku.instaln.R;
import com.android.kohaku.instaln.data.Model.Novel;
import com.android.kohaku.instaln.ui.base.BaseActivity;
import com.android.kohaku.instaln.ui.novel.NovelActivity;
import com.android.kohaku.instaln.ui.novelList.model.NovelListItem;
import com.mindorks.placeholderview.PlaceHolderView;

import java.util.List;

/**
 * Created by monis.q on 04-03-2018.
 */

public class NovelListActivity extends BaseActivity<NovelListPresenter>
        implements NovelListContract.View {

    PlaceHolderView mNovelView;

    NovelListPresenter mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitvit_novel_list_layout);
        mPresenter = createPresent();
        mPresenter.onAttach(this);
        mNovelView = findViewById(R.id.novelListView);
        mPresenter.addNovel("Overgeared", "http://novelplanet.com/Novel/Overgeared/");
//        mPresenter.addNovel("Library of Heaven's Path", "http://novelplanet.com/Novel/Library-of-Heaven-s-Path");
//        mPresenter.addNovel("The Book Eating Magician", "http://novelplanet.com/Novel/The-Book-Eating-Magician");
        mPresenter.loadNovels();
    }

    @Override
    public void showNovels(List<Novel> novelList) {
        mNovelView.removeAllViews();
        for (Novel novel : novelList) {
            mNovelView.addView(new NovelListItem(this, novel));
        }
    }

    @Override
    public void novelClicked(Novel novel) {
        Intent i = new Intent(this, NovelActivity.class);
        i.putExtra("novelName", novel.getNovelName());
        startActivity(i);
    }

    @Override
    protected NovelListPresenter createPresent() {
        return new NovelListPresenter(getDataManager(), this);
    }

    @Override
    protected void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }
}
