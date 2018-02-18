package com.android.kohaku.instaln.data;

import com.android.kohaku.instaln.data.Model.Chapter;
import com.android.kohaku.instaln.data.Model.Content;
import com.android.kohaku.instaln.data.Model.Novel;
import com.android.kohaku.instaln.data.database.PaperDB;
import com.android.kohaku.instaln.data.network.ArticleHelper;
import com.android.kohaku.instaln.data.network.ChapterHelper;

import org.androidannotations.annotations.Background;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import io.paperdb.Book;

/**
 * Created by monis.q on 04-02-2018.
 */

public class AppDataManager implements DataManager {

    private ArticleHelper mArticleHelper;
    private ChapterHelper mChapterHelper;
    private PaperDB mPaperDB;

    public AppDataManager(ArticleHelper articleHelper, ChapterHelper chapterhelper, PaperDB paperDB) {
        mArticleHelper = articleHelper;
        mChapterHelper = chapterhelper;
        mPaperDB = paperDB;
    }

    @Override
    public void writeChapters(String chapterBookName, List<Chapter> chapterList) {
        for (Chapter chapter : chapterList) {
            writeBook(chapterBookName, chapter.getChapterUrl(), chapter);
        }
    }

    @Override
    @Background
    public Novel addNovel(String novelName, String urlString) throws IOException {
        Novel novel = new Novel(novelName, urlString);
        writeBook(NOVEL_BOOK_NAME, novelName, novel);//Todo: append a unique string to novelName
        List<Chapter> chapterList = getAllChaptersList(novel);
        writeChapters(novelName, chapterList);
        return novel;
    }

    @Override
    public Content getContent(Chapter chapter) throws IOException {
        String contentKey = chapter.getChapterUrl();
        if (contains(CONTENT_BOOK_NAME, contentKey)) {
            return readBook(CONTENT_BOOK_NAME, contentKey);
        }
        Content content = mArticleHelper.getContent(chapter);
        writeBook(CONTENT_BOOK_NAME, contentKey, content);
        return content;
    }

    @Override
    public List<Novel> getAllNovel() {
        List<String> novelNames = getAllKeys(NOVEL_BOOK_NAME);
        List<Novel> novelList = Collections.emptyList();
        Novel novelTempObject;
        for (String novelKey : novelNames) {
            novelTempObject = readBook(NOVEL_BOOK_NAME, novelKey);
            novelList.add(novelTempObject);
        }
        return novelList;
    }

    @Override
    public List<Chapter> getAllChaptersList(Novel novel) throws IOException {
        return mChapterHelper.getAllChaptersList(novel);
    }

    @Override
    public <T> T readBook(String bookName, String key) {
        return mPaperDB.readBook(bookName, key);
    }

    @Override
    public <T> Book writeBook(String bookName, String key, T value) {
        return mPaperDB.writeBook(bookName, key, value);
    }

    @Override
    public boolean contains(String bookName, String key) {
        return mPaperDB.contains(bookName, key);
    }

    @Override
    public void delete(String bookName, String key) {
        mPaperDB.delete(bookName, key);
    }

    @Override
    public List<String> getAllKeys(String bookName) {
        return mPaperDB.getAllKeys(bookName);
    }
}
