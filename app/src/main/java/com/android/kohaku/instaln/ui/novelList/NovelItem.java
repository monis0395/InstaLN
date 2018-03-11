package com.android.kohaku.instaln.ui.novelList;

import android.content.Context;
import android.widget.TextView;

import com.android.kohaku.instaln.R;
import com.android.kohaku.instaln.data.Model.Novel;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;

/**
 * Created by monis.q on 11-03-2018.
 */

@Layout(R.layout.novel_list_item)
public class NovelItem {

    @View(R.id.novelName)
    private TextView novelNameTxt;

    private Context mContext;
    private Novel mNovel;

    public NovelItem(Context context, Novel novel) {
        mContext = context;
        mNovel = novel;
    }

    @Resolve
    private void onResolved() {
        novelNameTxt.setText(mNovel.getNovelName());
    }
}
