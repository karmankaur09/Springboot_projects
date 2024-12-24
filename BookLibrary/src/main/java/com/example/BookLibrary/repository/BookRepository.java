package com.example.BookLibrary.repository;

import com.example.BookLibrary.model.Book;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.OptionalInt;
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
