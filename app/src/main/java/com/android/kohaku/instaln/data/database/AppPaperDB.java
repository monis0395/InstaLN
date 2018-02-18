package com.android.kohaku.instaln.data.database;

import java.util.List;

import io.paperdb.Book;
import io.paperdb.Paper;

/**
 * Created by monis.q on 18-02-2018.
 */

public class AppPaperDB implements PaperDB {

    @Override
    public <T> T readBook(String bookName, String key) {
        return Paper.book(bookName).read(key);
    }

    @Override
    public <T> Book writeBook(String bookName, String key, T value) {
        return Paper.book(bookName).write(key, value);
    }

    @Override
    public boolean contains(String bookName, String key) {
        return Paper.book(bookName).contains(key);
    }

    @Override
    public void delete(String bookName, String key) {
        Paper.book(bookName).delete(key);
    }

    @Override
    public List<String> getAllKeys(String bookName) {
        return Paper.book(bookName).getAllKeys();
    }
}
