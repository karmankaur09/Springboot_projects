package com.example.BookLibrary.service;

import com.example.BookLibrary.model.Book;
import com.example.BookLibrary.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository ObjRepo;
    // Constructor-based Dependency Injection
//    public BookService(BookRepository Obj){
//        this.Obj = Obj;
//    }
    public List<Book> getAllBook() {
        return ObjRepo.findAll();
    }

    public Book getBookById(Long id) {
        List<Book> booksList = ObjRepo.findAll();
        for (Book book : booksList) {
            if (book.getId().equals(id)) {
                return book; // Return directly from the list
            }
        }
        return null; // Return null if not found
    }
    //public Book createBook(@RequestBody Book clientBook){   //clienBook-outside var
//        Long sizeOfBookList = Long.valueOf(booksList.size());  //size of current booklist = 4
//        clientBook.setId((Long)(sizeOfBookList+1));           //where increase size to 5 and setting it to clientbook
//        booksList.add(clientBook);               //saving clientbook in databse ie booklist
//        return clientBook;   //return the clienbook with id for user confirmation
//    }
    public Book createBook(Book clientBook){
        return ObjRepo.save(clientBook);
    }

    public void deleteBook(Long id){
        List<Book> booksList = ObjRepo.findAll();
        for (Book book: booksList){
            if (book.getId().equals(id)){
                ObjRepo.delete(book);
            }
        }
        System.out.println("The Book with given Id:"+ id+ "is not present");
    }

    public Book updateBook(Long id,Book clientBook){
        Book currentBook = ObjRepo.getReferenceById(id);
        if (currentBook != null){
            currentBook.setName(clientBook.getname());
            currentBook.setAuthorName(clientBook.getAuthorName());
            return ObjRepo.save(currentBook);
        }
        System.out.println("The Book with given Id:"+ id+ "is not present");


        return  null;
    }

}
