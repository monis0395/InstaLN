package com.android.kohaku.instaln.data.database;

import java.util.List;

import io.paperdb.Book;

/**
 * Created by monis.q on 18-02-2018.
 */

public interface PaperDB {

    final String NOVEL_BOOK_NAME = "novel";
    final String CONTENT_BOOK_NAME = "chapter";

    <T> T readBook(String bookName, String key);

    <T> Book writeBook(String bookName, String key, T value);

    public boolean contains(String bookName, String key);

    public void delete(String bookName, String key);

    public List<String> getAllKeys(String bookName);
}