package com.android.kohaku.instaln.ui.chapter.model;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.kohaku.instaln.R;
import com.android.kohaku.instaln.ui.chapter.ChapterContract;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by monis.q on 01-04-2018.
 */

public class TextResizingModal extends BottomSheetDialogFragment {

    Unbinder mUnbinder;
    ChapterContract.Listeners mListeners;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.modal_text_resize, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mUnbinder = ButterKnife.bind(this, view);
        mListeners = (ChapterContract.Listeners) getActivity();
    }

    void increaseTextSize() {
        mListeners.increaseTextSize();
    }

    void decreaseTextSize() {
        mListeners.decreaseTextSize();
    }

    void increaseMargin() {
        mListeners.increaseMargin();
    }

    void decreaseMargin() {
        mListeners.decreaseMargin();
    }

    void increaseTextLineHeight() {
        mListeners.increaseTextLineHeight();
    }

    void decreaseTextLineHeight() {
        mListeners.decreaseTextLineHeight();
    }
}
