package com.android.kohaku.instaln.data.network;

import com.android.kohaku.instaln.data.Model.Chapter;

import java.io.IOException;
import java.util.List;

public interface ChapterHelper {

    public List<Chapter> getAllChaptersList(String urlString) throws IOException;
}
