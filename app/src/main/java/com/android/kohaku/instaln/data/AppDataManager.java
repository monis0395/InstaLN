package com.android.kohaku.instaln.data;

import android.util.Log;

import com.android.kohaku.instaln.data.Model.Chapter;
import com.android.kohaku.instaln.data.Model.Content;
import com.android.kohaku.instaln.data.Model.Novel;
import com.android.kohaku.instaln.data.database.PaperDB;
import com.android.kohaku.instaln.data.network.ArticleHelper;
import com.android.kohaku.instaln.data.network.ChapterHelper;
import com.android.kohaku.instaln.utils.InstaUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.paperdb.Book;

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
    public <T> T readBook(String bookName, String key) {
        return mPaperDB.readBook(bookName, key);
    }

    @Override
    public <T> Book writeBook(String bookName, String key, T value) {
        return mPaperDB.writeBook(bookName, InstaUtils.urlEncode(key), value);
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

    @Override
    public List<Chapter> updateChapters(Novel novel) throws IOException {
        String bookName = novel.getNovelName();
        List<Chapter> chapters = getAllChaptersList(novel.getNovelUrl());
        for (Chapter chapter : chapters) {
            Log.v("monis", "updateChapters chapterUrl: " + chapter.getChapterUrl());
            writeBook(bookName,
                    String.valueOf(chapter.getChapterNumber()),
                    chapter);
        }
        return chapters;
    }

    @Override
    public Novel addNovel(String novelName, String urlString) throws IOException {
        Novel novel = new Novel(novelName, urlString);
        novel.setNovelSummary(getContent(urlString));
        updateChapters(novel);
        writeBook(NOVEL_BOOK,
                novelName,
                novel);//Todo: append a unique string to novelName
        Log.v("monis", "Novel added: " + novel.getNovelName());
        return novel;
    }

    @Override
    public Content getContent(String contentUrl) throws IOException {
        if (contains(CONTENT_BOOK, contentUrl)) {
            return readBook(CONTENT_BOOK, contentUrl);
        }

        Content content = mArticleHelper.getContent(contentUrl);
        writeBook(CONTENT_BOOK, contentUrl, content);
        return content;
    }

    @Override
    public List<Novel> getAllNovel() {
        List<String> novelNames = getAllKeys(NOVEL_BOOK);
        List<Novel> novelList = new ArrayList<>();
        Novel novelTempObject;
        for (String novelKey : novelNames) {
            Log.v("monis", "getAllNovel novelkey: " + novelKey);
            novelTempObject = readBook(NOVEL_BOOK, novelKey);
            novelList.add(novelTempObject);
        }
        return novelList;
    }

    @Override
    public List<Chapter> getAllChapters(Novel novel) {
        String bookName = novel.getNovelName();
        List<String> chapterKeys = getAllKeys(bookName);
        List<Chapter> chapters = new ArrayList<>();
        Chapter chapterTempObject;
        for (String chapterKey : chapterKeys) {
            chapterTempObject = readBook(bookName, chapterKey);
            chapters.add(chapterTempObject);
        }
        return chapters;
    }

    @Override
    public List<Chapter> getAllChaptersList(String urlString) throws IOException {
        return mChapterHelper.getAllChaptersList(urlString);
    }
}
