package com.android.kohaku.instaln.ui.novelList.model;

import android.content.Context;
import android.widget.TextView;

import com.android.kohaku.instaln.R;
import com.android.kohaku.instaln.data.Model.Novel;
import com.android.kohaku.instaln.ui.novelList.NovelListContract;
import com.mindorks.placeholderview.annotations.Click;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;

/**
 * Created by monis.q on 11-03-2018.
 */

@Layout(R.layout.novel_list_item)
public class NovelListItem {

    @View(R.id.novelName)
    TextView novelNameTxt;

    private Context mContext;
    private Novel mNovel;

    public NovelListItem(Context context, Novel novel) {
        mContext = context;
        mNovel = novel;
    }

    @Resolve
    public void onResolved() {
        novelNameTxt.setText(mNovel.getNovelName());
    }

    @Click(R.id.novelName)
    public void openNovel() {
        ((NovelListContract.View) mContext).novelClicked(mNovel);
    }
}
