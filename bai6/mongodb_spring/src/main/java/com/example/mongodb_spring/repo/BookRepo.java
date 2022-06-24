package com.example.mongodb_spring.repo;

import com.example.mongodb_spring.Model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Date;
import java.util.List;

public interface BookRepo extends MongoRepository<Book, String> {
//    Optional<Book> findByNameContains(String name);

    Page<Book> findBookByPublicationDateBetween(Date start, Date End,Pageable  pageable);
    @Query("{$text: {$search: ?0}}")
    List<Book> findByText(String text);

}
