package com.example.BookLibrary.controllers;

import com.example.BookLibrary.model.Book;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BookController {
    private List<Book> books = new ArrayList<>(); //arraylist for saving the book in place of database

    public BookController(){ //default constructor
        books.add(new Book(1,"Angel","Stephen"));
        books.add(new Book(2,"sweet 16","Malika"));
        books.add(new Book(3,"Atomic habits","Japenese"));
        books.add(new Book(4,"How to think","Nargois"));
    }
}
