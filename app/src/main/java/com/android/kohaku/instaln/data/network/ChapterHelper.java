package com.android.kohaku.instaln.data.network;

import com.android.kohaku.instaln.data.Model.Chapter;
import com.android.kohaku.instaln.data.Model.Novel;

import java.io.IOException;
import java.util.List;

/**
 * Created by monis.q on 04-02-2018.
 */

public interface ChapterHelper {

    public List<Chapter> getAllChaptersList(Novel novel) throws IOException;
}
