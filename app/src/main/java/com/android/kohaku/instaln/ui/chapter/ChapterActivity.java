package com.android.kohaku.instaln.ui.chapter;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.android.kohaku.instaln.R;
import com.android.kohaku.instaln.data.Model.Chapter;
import com.android.kohaku.instaln.data.Model.Content;
import com.android.kohaku.instaln.ui.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ChapterActivity extends BaseActivity<ChapterPresenter> implements ChapterContract.View, ChapterContract.Listeners{

    @BindView(R.id.chapterName)
    TextView chapterNameTxt;

    @BindView(R.id.contentView)
    TextView mContentView;

    @BindView(R.id.fullscreen_content_controls)
    View mControlsView;

    protected ChapterPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter);
        mVisible = true;
        setUnBinder(ButterKnife.bind(this));
        mPresenter = createPresent();
        mPresenter.onAttach(this);

        setUp();
    }

    @OnClick(R.id.contentView)
    public void contentClicked() {
        toggle();    // Set up the user interaction to manually show or hide the system UI.
    }

    @OnClick(R.id.themeSettings)
    public void themeSettingsButtonClicked() {
        controlClicked();

        Log.v("monis", "themeSettings button");
    }

    private void setUp() {
        String novelName = getIntent().getStringExtra("novelName");
        String chapterNumber = getIntent().getStringExtra("chapterNumber");

        mPresenter.loadContent(novelName, chapterNumber);
    }

    @Override
    public void showContent(@NonNull Chapter chapter, @NonNull Content content) {
        chapterNameTxt.setText(chapter.getChapterName());

        Spanned spanned = Html.fromHtml(content.getContent(), Html.FROM_HTML_MODE_COMPACT);
        mContentView.setText(spanned);
    }

    @Override
    public void loadNextChapter(Chapter chapter) {

    }

    @Override
    public void loadPreviousChapter(Chapter chapter) {

    }

    @Override
    protected ChapterPresenter createPresent() {
        return new ChapterPresenter(getDataManager(), this);
    }

    @Override
    public void increaseTextSize() {

    }

    @Override
    public void decreaseTextSize() {

    }

    @Override
    public void increaseMargin() {

    }

    @Override
    public void decreaseMargin() {

    }

    @Override
    public void increaseTextLineHeight() {

    }

    @Override
    public void decreaseTextLineHeight() {

    }


    //Immersion Controls
    private boolean mVisible;
    /**
     * Whether or not the system UI should be auto-hidden after
     * {@link #AUTO_HIDE_DELAY_MILLIS} milliseconds.
     */
    private static final boolean AUTO_HIDE = true;

    /**
     * If {@link #AUTO_HIDE} is set, the number of milliseconds to wait after
     * user interaction before hiding the system UI.
     */
    private static final int AUTO_HIDE_DELAY_MILLIS = 3000;

    /**
     * Some older devices needs a small delay between UI widget updates
     * and a change of the status and navigation bar.
     */
    private static final int UI_ANIMATION_DELAY = 300;

    private final Handler mHideHandler = new Handler();

    private final Runnable mHidePart2Runnable = () -> mContentView
            .setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                    | View.SYSTEM_UI_FLAG_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

    private final Runnable mShowPart2Runnable = () -> {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.show();
        }
        mControlsView.setVisibility(View.VISIBLE);
    };

    private final Runnable mHideRunnable = this::hide;

    private void toggle() {
        if (mVisible) {
            hide();
        } else {
            show();
        }
    }

    private void hide() {
        // Hide UI first
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        mControlsView.setVisibility(View.GONE);
        mVisible = false;

        // Schedule a runnable to remove the status and navigation bar after a delay
        mHideHandler.removeCallbacks(mShowPart2Runnable);
        mHideHandler.postDelayed(mHidePart2Runnable, UI_ANIMATION_DELAY);
    }

    @SuppressLint("InlinedApi")
    private void show() {
        // Show the system bar
        mContentView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
        mVisible = true;

        // Schedule a runnable to display UI elements after a delay
        mHideHandler.removeCallbacks(mHidePart2Runnable);
        mHideHandler.postDelayed(mShowPart2Runnable, UI_ANIMATION_DELAY);
    }

    /**
     * Schedules a call to hide() in delay milliseconds, canceling any
     * previously scheduled calls.
     */
    private void delayedHide(int delayMillis) {
        mHideHandler.removeCallbacks(mHideRunnable);
        mHideHandler.postDelayed(mHideRunnable, delayMillis);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Trigger the initial hide() shortly after the activity has been
        // created, to briefly hint to the user that UI controls
        // are available.
        delayedHide(100);
    }

    /**
     * Touch listener to use for in-layout UI controls to delay hiding the
     * system UI. This is to prevent the jarring behavior of controls going away
     * while interacting with activity UI.
     */
    private void controlClicked() {
        if (AUTO_HIDE) {
            delayedHide(AUTO_HIDE_DELAY_MILLIS);
        }
    }
}
