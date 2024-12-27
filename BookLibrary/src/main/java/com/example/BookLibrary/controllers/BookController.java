package com.example.BookLibrary.controllers;

import com.example.BookLibrary.model.Book;
import com.example.BookLibrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService ObjService;

    @GetMapping
    public List<Book> getAllBook() {
        return ObjService.getAllBook();
    }

    @GetMapping("/{id}") //http://localhost:8080/books/4
    public Book getBookById(@PathVariable Long id) {
        return ObjService.getBookById(id);
    }

    @PostMapping
    public Book createBook(@RequestBody Book clientBook) {
        return ObjService.createBook(clientBook);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        ObjService.deleteBook(id);
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book clientBook) {
        return ObjService.updateBook(id, clientBook);
    }
}
