package com.android.kohaku.instaln.ui.chapterFullScreen;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.kohaku.instaln.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by monis.q on 25-03-2018.
 */

public class ModalBottom extends BottomSheetDialogFragment {

    @BindView(R.id.dialog_dummy_txt)
    TextView txt;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View contentView = inflater.inflate(R.layout.dialog_layout, container, false);

        ButterKnife.bind(this, contentView);

        return contentView;
    }


    @OnClick(R.id.dialog_dummy_txt)
    public void dummyClick() {
        Log.v("monis", "I am was Clicked");
        ModalListener activity = (ModalListener) getActivity();
        if (activity != null) {
            activity.dummyClicked("text");
        }
    }

    public interface ModalListener {
        void dummyClicked(String string);
    }
}
