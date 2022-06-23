package com.example.mongodb_spring.Service.Implement;

import com.example.mongodb_spring.Model.Book;
import com.example.mongodb_spring.Service.BookService;
import com.example.mongodb_spring.repo.BookRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class BookImpl implements BookService {

    @Autowired
    private BookRepo bookRepo;

    @Override
    public List<Book> getAll() {
        return bookRepo.findAll();
    }

    @Override
    public Book findBookById(String id) {
        Optional<Book> bookOp = this.bookRepo.findById(id);
        return bookOp.orElse(null);
    }

    @Override
    public String addBook(Book book) {
        this.bookRepo.save(book);
        return "Done!";
    }

    @Override
    public String deleteBook(String id) {
        this.bookRepo.deleteById(id);
        return "Delete success";
    }

    @Override
    public String updateBook(String id, Book book) {
        Book bookDB = this.findBookById(id);
        bookDB.setName(book.getName());
        bookDB.setAuthor(book.getAuthor());
        bookDB.setPublicationDate(book.getPublicationDate());
        bookDB.setDescribe((book.getDescribe()));
        this.bookRepo.save(bookDB);
        return "Done!";
    }

    @Override
    public List<Book> findByAuthorAndName(String author, String name) {
        return this.bookRepo.findBookByAuthorContainsAndNameContains(author,name);

    }

    @Override
    public List<Book> findBookByDate(Date start, Date end) {
        return this.bookRepo.findBookByPublicationDateBetween(start,end);
    }


}
