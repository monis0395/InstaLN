package com.android.kohaku.instaln;

import android.app.Application;

import com.android.kohaku.instaln.data.AppDataManager;
import com.android.kohaku.instaln.data.DataManager;
import com.android.kohaku.instaln.data.database.AppPaperDB;
import com.android.kohaku.instaln.data.network.AppArticleHelper;
import com.android.kohaku.instaln.data.network.AppChapterHelper;

import io.paperdb.Paper;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class InstaLNApp extends Application {
    DataManager mDataManager;
    CalligraphyConfig mCalligraphyConfig;

    @Override
    public void onCreate() {
        super.onCreate();
        mDataManager = new AppDataManager(new AppArticleHelper(), new AppChapterHelper(), new AppPaperDB());
        Paper.init(this.getApplicationContext());

        CalligraphyConfig.initDefault(mCalligraphyConfig);
    }
}
