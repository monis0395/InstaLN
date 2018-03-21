package com.android.kohaku.instaln.ui.novel.model;

import android.content.Context;
import android.text.Html;
import android.text.Spanned;
import android.widget.TextView;

import com.android.kohaku.instaln.R;
import com.android.kohaku.instaln.data.Model.Novel;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;

/**
 * Created by monis.q on 21-03-2018.
 */
@Layout(R.layout.novel_details_item)
public class NovelDetailsItem {

    @View(R.id.novelName)
    TextView novelNameTxt;

    @View(R.id.summaryDetails)
    TextView summaryDetailsTxt;

    private Novel mNovel;
    private Context mContext;

    public NovelDetailsItem(Context context, Novel novel) {
        mContext = context;
        mNovel = novel;
    }

    @Resolve
    public void onResolved() {
        novelNameTxt.setText(mNovel.getNovelName());

        Spanned spanned = Html.fromHtml(mNovel.getNovelSummary().getContent(), Html.FROM_HTML_MODE_COMPACT);
        summaryDetailsTxt.setText(spanned);
    }
}
