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
    private List<Book> booksList = new ArrayList<>(); //arraylist for saving the book in place of database

    public BookController(){ //default constructor
        booksList.add(new Book(1L,"Angel","Stephen"));
        booksList.add(new Book(2L,"sweet 16","Malika"));
        booksList.add(new Book(3L,"Atomic habits","Japenese"));
        booksList.add(new Book(4L,"How to think","Nargois"));
    }
    @Autowired
    private BookService Obj;
   // @GetMapping      //request URL = http://localhost:8080/books
//    public List<Book> getAllBook(){
//        return booksList;
//    }
    @GetMapping
    public List<Book> getAllBook(){
        return Obj.getAllBook();
    }
    @GetMapping("/{id}") //http://localhost:8080/books/4
    public Book getBookById(@PathVariable Long id){
        return Obj.getBookById(id);
    }
//    @GetMapping("/{id}") //http://localhost:8080/books/4
//    public Book getBookById(@PathVariable Long id){
//        for (Book book : booksList){
//            if (book.getId().equals(id)){
//                return book;
//            }
//        }
//        return null;
//    }
//    {
//        "name":"think big",
//            "authorName":"Nepolean"
//    }
    @PostMapping
    public Book createBook(@RequestBody Book clientBook){   //clienBook-outside var
        Long sizeOfBookList = Long.valueOf(booksList.size());  //size of current booklist = 4
        clientBook.setId((Long)(sizeOfBookList+1));           //where increase size to 5 and setting it to clientbook
        booksList.add(clientBook);               //saving clientbook in databse ie booklist
        return clientBook;   //return the clienbook with id for user confirmation
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id){
        for (Book book : booksList) {
            if (book.getId().equals(id)) {
                booksList.remove(book);
                break;
            }
        }
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book clientBook){
        Book currentBook = null;
        for(Book book : booksList){
            if(book.getId().equals(id)){
                currentBook = book;
                break;
            }
        }
        if (currentBook != null){
            currentBook.setName(clientBook.getname());
            currentBook.setAuthorName(clientBook.getAuthorName());
            return currentBook;
        }
        return  null;
    }


}
