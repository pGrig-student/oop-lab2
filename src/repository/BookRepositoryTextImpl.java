package repository;

import book.Book;

import java.io.File;

public class BookRepositoryTextImpl implements BookRepository {
    @Override
    public void outputArray(Book[] t, File file) {

    }

    @Override
    public void outputArray(Book[] t, String fileName) {

    }

    @Override
    public Book[] readArray(File file) {
        return new Book[0];
    }

    @Override
    public Book[] readArray(String fileName) {
        return new Book[0];
    }
}
