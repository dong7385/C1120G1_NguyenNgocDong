package com.example.book.service;

import com.example.book.exceptions.OutOfRemainQuantityException;
import com.example.book.exceptions.WrongBookIdException;
import com.example.book.model.Book;

import java.util.List;

public interface BookService {
    List<Book> findAll();

    Book findById(String id);

    boolean isAvailable(Book book);

    void borrowBook(String id) throws OutOfRemainQuantityException;

    void returnBook(String id) throws WrongBookIdException;
}
