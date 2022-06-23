package com.example.mongodb_spring.repo;

import com.example.mongodb_spring.Model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;
@Repository
public interface BookRepo extends MongoRepository<Book, String> {
//    Optional<Book> findByNameContains(String name);

    List<Book> findBookByAuthorContainsAndNameContains(String author, String name );
    List<Book> findBookByAuthorContains(String author);
    List<Book> findBookByNameContains(String name);
    List<Book> findBookByPublicationDateBetween(Date start, Date End);
}
