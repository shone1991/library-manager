package org.example;

import org.example.author.Author;
import org.example.book.Book;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Database {
    private static final String AUTHORS_TABLE = "authors.dat";
    private static final String BOOKS_TABLE = "books.dat";
    public static Map<Long, Author> authors=new HashMap<>();
    public static Map<Long, Book> books=new HashMap<>();

    @SuppressWarnings("unchecked")
    public void loadAuthorsTable() {
        File file = new File(AUTHORS_TABLE);
        if (!file.exists()) {
            System.out.println("No existing data for author found, starting fresh.");
            return;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            authors = (Map<Long, Author>) ois.readObject();
            System.out.println("Author data loaded successfully.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Failed to load author data: " + e.getMessage());
        }
    }

    public void saveAuthorData() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(AUTHORS_TABLE))) {
            oos.writeObject(authors);
            System.out.println("Author data saved successfully.");
        } catch (IOException e) {
            System.err.println("Failed to save author data: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public void loadBooksTable() {
        File file = new File(BOOKS_TABLE);
        if (!file.exists()) {
            System.out.println("No existing data found for books table, starting fresh.");
            return;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            books = (Map<Long, Book>) ois.readObject();
            System.out.println("Books data loaded successfully.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Failed to load book data: " + e.getMessage());
        }
    }

    public void saveBookData() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(BOOKS_TABLE))) {
            oos.writeObject(books);
            System.out.println("Books data saved successfully.");
        } catch (IOException e) {
            System.err.println("Failed to save book data: " + e.getMessage());
        }
    }
}
