package com.android.kohaku.instaln.ui.novelList;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.android.kohaku.instaln.R;
import com.android.kohaku.instaln.data.Model.Novel;
import com.android.kohaku.instaln.ui.base.BaseActivity;
import com.android.kohaku.instaln.ui.novel.NovelActivity;
import com.mindorks.placeholderview.PlaceHolderView;

import net.the4thdimension.android.Utils;

import java.util.List;

/**
 * Created by monis.q on 04-03-2018.
 */

public class NovelListActivity extends BaseActivity<NovelListPresenter>
        implements NovelListContract.View {

    PlaceHolderView mNovelView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitvit_novel_list_layout);
        mNovelView = findViewById(R.id.novelView);
        mPresenter.loadNovels();
    }

    @Override
    public void showNovels(List<Novel> novelList) {
        for (Novel novel: novelList) {
            Log.v("monis novel: ", novel.getNovelName());
            mNovelView.addView(new NovelItem(this, novel));
        }
    }

    @Override
    public void novelClicked(Novel novel) {
//        Utils.showToast(this, novel.getNovelName());
        Intent i = new Intent(this,NovelActivity.class);
        i.putExtra("novel", novel.getNovelName());
        startActivity(i);
        Utils.showToast(this, "starting novel activity");

    }

    @Override
    protected NovelListPresenter createPresent() {
        return new NovelListPresenter(getDataManager());
    }
}
