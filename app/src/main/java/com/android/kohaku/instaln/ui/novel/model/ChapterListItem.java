package com.android.kohaku.instaln.ui.novel.model;

import android.content.Context;
import android.widget.TextView;
import android.widget.Toast;

import com.android.kohaku.instaln.R;
import com.android.kohaku.instaln.data.Model.Chapter;
import com.android.kohaku.instaln.ui.novel.NovelContract;
import com.mindorks.placeholderview.annotations.Click;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;

import net.the4thdimension.android.Utils;

/**
 * Created by monis.q on 17-03-2018.
 */

@Layout(R.layout.chapter_list_item)
public class ChapterListItem {

    @View(R.id.chapterNumber) TextView chapterNumberTxt;

    @View(R.id.chapterName) TextView chapterNameTxt;

    private Chapter mChapter;
    private Context mContext;

    public ChapterListItem(Context context, Chapter chapter) {
        mContext = context;
        mChapter = chapter;
    }

    @Resolve
    public void onResolved() {
        String chapterNumber = Integer.toString(mChapter.getChapterNumber());
        chapterNumberTxt.setText(chapterNumber);
        chapterNameTxt.setText(mChapter.getChapterName());
    }

    @Click(R.id.chapterItem)
    public void chapterNameClicked() {
        ((NovelContract.View) mContext).chapterClicked(mChapter);
    }
}
