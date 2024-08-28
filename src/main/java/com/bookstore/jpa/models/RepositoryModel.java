package com.bookstore.jpa.models;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;
import java.util.List;
import java.util.ArrayList;

public class RepositoryModel implements Serializable {

    static LibraryModel library;

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    public void Repository(LibraryModel library){
        RepositoryModel.library = new LibraryModel();
    }

    public void removeBook(BookModel book) {
        library.books.remove(book);
    }

    public void removeBook(int index) {
        if (index < 0 || index >= library.books.size()) {
            System.out.println("Invalid index.");
        } else {
            library.books.remove(index);
        }
    }

    public void addBook(BookModel book) {
        library.books.add(book);
    }

    public void removeBook(String title) {
        library.books.removeIf(book -> book.getTitle().equals(title));
    }

    public int findBook(String title) {
        for (int i = 0; i < library.books.size(); i++) {
            if (library.books.get(i).getTitle().equals(title)) {
                return i;
            }
        }
        return -1;
    }

    public List<String> listAllBooks() {
        List<String> bookList = new ArrayList<>();
        for (BookModel book : library.books) {
            bookList.add("Title: " + book.getTitle() + ", Author: " + book.getAuthor() + ", ISBN: " + book.getISBN());
        }
        return bookList;

    }

}

