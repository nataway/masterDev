package com.example.mongodb_spring.Service;

import com.example.mongodb_spring.Model.Book;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service

public interface BookService {
    List<Book> getAll();
    Book findBookById(String Id);
    String addBook(Book book);
    String deleteBook(String id);
    String updateBook(String id, Book book);
    List<Book> findByAuthorAndName(String author, String name);

    List<Book> findBookByDate(Date start, Date end);

}
