package com.example.BookLibrary.service;

import com.example.BookLibrary.model.Book;
import com.example.BookLibrary.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository Obj;
    // Constructor-based Dependency Injection
//    public BookService(BookRepository Obj){
//        this.Obj = Obj;
//    }
    public List<Book> getAllBook() {
        return Obj.findAll();
    }

    public Book getBookById(Long id) {
        List<Book> booksList = Obj.findAll();
        for (Book book : booksList) {
            if (book.getId().equals(id)) {
                return book; // Return directly from the list
            }
        }
        return null; // Return null if not found
    }

}
