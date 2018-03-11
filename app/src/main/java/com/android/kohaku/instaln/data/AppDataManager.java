package com.android.kohaku.instaln.data;

import android.util.Log;

import com.android.kohaku.instaln.data.Model.Chapter;
import com.android.kohaku.instaln.data.Model.Content;
import com.android.kohaku.instaln.data.Model.Novel;
import com.android.kohaku.instaln.data.database.PaperDB;
import com.android.kohaku.instaln.data.network.ArticleHelper;
import com.android.kohaku.instaln.data.network.ChapterHelper;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
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
        try {
            key = URLEncoder.encode(key, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
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

    @Override
    public void updateChapters(Novel novel) throws IOException {
        String bookName = novel.getNovelName();
        for (Chapter chapter : getAllChaptersList(novel.getNovelUrl())) {
            writeBook(bookName, chapter.getChapterUrl(), chapter);
        }
    }

    @Override
    public Novel addNovel(String novelName, String urlString) throws IOException {
        Novel novel = new Novel(novelName, urlString);
        novel.setNovelSummary(getContent(urlString));
        updateChapters(novel);
        writeBook(NOVEL_BOOK, novelName, novel);//Todo: append a unique string to novelName
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
            novelTempObject = readBook(NOVEL_BOOK, novelKey);
            novelList.add(novelTempObject);
        }
        return novelList;
    }

    public List<Chapter> getAllChapters(Novel novel) throws IOException {
        String bookName = novel.getNovelName();
        List<String> chapterKeys = getAllKeys(bookName);
        List<Chapter> chapters = new ArrayList<>();
        Chapter chapterTempObject;
        for (String chapterKey : chapterKeys) {
            chapterTempObject = readBook(bookName, chapterKey);
            chapters.add(chapterTempObject);
        }
        return chapters;
    };

    @Override
    public List<Chapter> getAllChaptersList(String urlString) throws IOException {
        return mChapterHelper.getAllChaptersList(urlString);
    }
}
