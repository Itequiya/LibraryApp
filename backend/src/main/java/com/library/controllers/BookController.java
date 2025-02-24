package com.library.controllers;
import com.library.model.Book;
import com.library.model.Library;
import com.library.service.LibraryService;
import com.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")

public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/All") //
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }
    @GetMapping("/getBookByTitle")
    public Book getBookByTitle(@RequestParam("title") String title){
        return bookService.getBookByTitle(title);
    }

    @PostMapping("/AddBook")
    public Book AddBook(@RequestBody Book book){
        return bookService.AddBook(book);
    }
    @DeleteMapping("/deleteBook")
    public void deleteBook(@RequestParam String title){
        bookService.DeleteBook(title);
    }
}
