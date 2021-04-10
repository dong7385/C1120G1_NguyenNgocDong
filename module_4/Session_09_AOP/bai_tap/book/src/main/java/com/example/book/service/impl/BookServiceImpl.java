package com.example.book.service.impl;

import com.example.book.exceptions.OutOfRemainQuantityException;
import com.example.book.exceptions.WrongBookIdException;
import com.example.book.model.Book;
import com.example.book.repository.BookRepository;
import com.example.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(String id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public boolean isAvailable(Book book) {
        return book.getAmount() > 0;
    }

    @Override
    public void borrowBook(String id) throws OutOfRemainQuantityException {
        Book book = findById(id);
        if (isAvailable(book)) {
            book.setAmount(book.getAmount() - 1);
            bookRepository.save(book);
        } else {
            throw new OutOfRemainQuantityException();
        }
    }

    @Override
    public void returnBook(String id) throws WrongBookIdException {
        Book book = findById(id);
        if (book != null) {
            book.setAmount(book.getAmount() + 1);
            bookRepository.save(book);
        } else {
            throw new WrongBookIdException();
        }
    }
}

