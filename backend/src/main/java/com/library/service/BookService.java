package com.library.service;
import com.library.model.Book;
import com.library.repository.BookRepository;
import com.library.repository.CopyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    private CopyRepository copyRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
    public Integer Available(Long book_id) {return copyRepository.availableCopies(book_id); }
    public Book getBookByTitle(String title){ return bookRepository.findByTitle(title);}
    public Book AddBook (Book book){
        return bookRepository.save(book);
    }
    public void DeleteBook (String title){
        bookRepository.deleteByTitle(title);
    }
}
