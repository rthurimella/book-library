package com.application.courseLibrary.controller;

import com.application.courseLibrary.entity.Book;
import com.application.courseLibrary.entity.Category;
import com.application.courseLibrary.entity.Publisher;
import com.application.courseLibrary.service.AuthorService;
import com.application.courseLibrary.service.CategoryService;
import com.application.courseLibrary.service.PublisherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.application.courseLibrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;

    @Autowired
    private PublisherService publisherService;

    @Autowired
    private AuthorService authorService;

    @Autowired
    private CategoryService categoryService;


    @GetMapping("/books")
    public String findAllBooks(Model model){
        List<Book> books = bookService.findAllBooks();
        model.addAttribute("books", books);
        return "books";
    }

    @GetMapping("/book/{id}")
    public String findBook(@PathVariable Long id, Model model){
        Book book = bookService.findBookById(id);
        model.addAttribute("book", book);
        return "list-book";
    }

    @GetMapping("/remove-book/{id}")
    public String deleteBook(@PathVariable Long id, Model model){
        bookService.deleteBook(id);
        model.addAttribute("books", bookService.findAllBooks());
        return "books";
    }

    @GetMapping("/update-book/{id}")
    public String updateBook(@PathVariable Long id, Model model){
        Book book = bookService.findBookById(id);

        model.addAttribute("book", book);
        model.addAttribute("categories", categoryService.findAllCategories());
        model.addAttribute("authors", authorService.findAllAuthors());
        model.addAttribute("publishers", publisherService.findAllPublishers());

        return "update-book";
    }

    @PostMapping("/save-update/{id}")
    public String updateBook(@PathVariable Long id, Book book, BindingResult result, Model model){
        if (result.hasErrors()) return "update-book";

        bookService.updateBook(book);
        model.addAttribute("books",bookService.findAllBooks());

        return "redirect:/books";
    }
}
