package com.example.mongodb_spring.Serviece;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface Book {
    List<Book> getAll();
    Book findBookById(String id);
    String addBook(Book book);
    String deleteBook();

}
