package repository;

import book.Book;
import com.google.gson.Gson;

import java.io.*;
import java.nio.file.Files;

import com.google.gson.GsonBuilder;

public class BookRepositoryTextImpl implements BookRepository {
    @Override
    public void outputArray(Book[] books, File file) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String jsonText = gson.toJson(books);

        try {
            Files.writeString(file.toPath(), jsonText);
            System.out.println("Дані успішно збережено у JSON!");
        } catch (IOException e) {
            System.out.println("Помилка запису файлу: " + e.getMessage());
        }
    }

    @Override
    public void outputArray(Book[] t, String fileName) {
        outputArray(t, new File(fileName));
    }

    @Override
    public Book[] readArray(File file) {
        try (Reader reader = new FileReader(file)) {

            Gson gson = new Gson();

            return gson.fromJson(String.valueOf(reader), Book[].class);

        } catch (IOException e) {
            System.out.println("Помилка читання файлу: " + e.getMessage());
            return new Book[0];
        }
    }

    @Override
    public Book[] readArray(String fileName) {
        return readArray(new File(fileName));
    }
}
