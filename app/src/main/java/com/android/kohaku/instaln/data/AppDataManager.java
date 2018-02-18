package com.android.kohaku.instaln.data;

import com.android.kohaku.instaln.data.Model.Chapter;
import com.android.kohaku.instaln.data.Model.Content;
import com.android.kohaku.instaln.data.Model.Novel;
import com.android.kohaku.instaln.data.database.PaperDB;
import com.android.kohaku.instaln.data.network.ArticleHelper;
import com.android.kohaku.instaln.data.network.ChapterHelper;

import java.io.IOException;
import java.util.Collections;
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
    public void updateChapters(Novel novel) throws IOException {
        String bookName = novel.getNovelName();
        for (Chapter chapter : getAllChaptersList(novel.getNovelUrl())) {
            writeBook(bookName, chapter.getChapterUrl(), chapter);
        }
    }

    @Override
    public Novel addNovel(String novelName, String urlString) throws IOException {
        Novel novel = new Novel(novelName, urlString);
        writeBook(NOVEL_BOOK, novelName, novel);//Todo: append a unique string to novelName
        novel.setNovelSummary(getContent(urlString));
        updateChapters(novel);
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
        List<Novel> novelList = Collections.emptyList();
        Novel novelTempObject;
        for (String novelKey : novelNames) {
            novelTempObject = readBook(NOVEL_BOOK, novelKey);
            novelList.add(novelTempObject);
        }
        return novelList;
    }

    @Override
    public List<Chapter> getAllChaptersList(String urlString) throws IOException {
        return mChapterHelper.getAllChaptersList(urlString);
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
