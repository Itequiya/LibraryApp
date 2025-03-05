package com.library.controllers;
import com.library.model.Book;
import com.library.model.Category;
import com.library.model.CategoryBook;
import com.library.model.CategoryBookRequest;
import com.library.service.BookService;
import com.library.service.CopyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")

public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private CopyService copyService;

    @GetMapping("/all") //
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }
    @GetMapping("/getBookByTitle")
    public Book getBookByTitle(@RequestParam("title") String title){
        return bookService.getBookByTitle(title);
    }

    @PostMapping("/addBook")
    public Book AddBook(@RequestBody Book book){
        return bookService.AddBook(book);
    }
    @DeleteMapping("/deleteBook")
    public void deleteBook(@RequestParam String title){
        bookService.DeleteBook(title);
    }
    @GetMapping("/availableCopies")
    public Integer getAvailableCopies(@RequestParam("bookId") Long bookId){
        return copyService.getAvailable(bookId);
    }

    @PostMapping("/addCategoryToBook")
    public void AddCategoryToBook(@Valid @RequestBody CategoryBookRequest categoryBookRequest){
        bookService.AddCategoryToBook(categoryBookRequest);
    }
}
