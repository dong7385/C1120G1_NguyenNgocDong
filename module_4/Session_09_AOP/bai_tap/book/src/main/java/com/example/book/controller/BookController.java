package com.example.book.controller;

import com.example.book.exceptions.OutOfRemainQuantityException;
import com.example.book.exceptions.WrongBookIdException;
import com.example.book.model.Book;
import com.example.book.service.BookService;
import com.example.book.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    BookService bookService;
    @Autowired
    LogService logService;

    @GetMapping("")
    public String index(Model model) {
        List<Book> bookList = bookService.findAll();
        model.addAttribute("bookList", bookList);
        return "index";
    }

    @GetMapping("{id}/view")
    public ModelAndView viewDetail(@PathVariable String id) {
        return new ModelAndView("view", "book", bookService.findById(id));
    }

    @GetMapping("/borrow")
    public String borrowBook(@RequestParam String id, Model model) throws OutOfRemainQuantityException {
        bookService.borrowBook(id);
        model.addAttribute("message", "Borrowed successfully!");
        model.addAttribute("bookList", bookService.findAll());
        return "index";
    }

    @GetMapping("/return")
    public String returnBook(@RequestParam String id, Model model) throws WrongBookIdException {
        bookService.returnBook(id);
        model.addAttribute("message", "Returned successfully!");
        model.addAttribute("bookList", bookService.findAll());
        return "index";
    }

    @ExceptionHandler({OutOfRemainQuantityException.class, WrongBookIdException.class})
    public ModelAndView catchBorrowException(Exception e) {
        return new ModelAndView("error", "message", e.getMessage());
    }
}
