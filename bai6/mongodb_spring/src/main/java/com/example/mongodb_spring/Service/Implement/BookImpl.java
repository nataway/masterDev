package com.example.mongodb_spring.Service.Implement;

import com.example.mongodb_spring.Exceptions.ApiException;
import com.example.mongodb_spring.Model.Book;
import com.example.mongodb_spring.Service.BookService;
import com.example.mongodb_spring.repo.BookRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
    public Book findBookById(String id) {
        Optional<Book> bookOp = this.bookRepo.findById(id);
        return bookOp.orElse(new Book());
    }

    @Override
    public String addBook(Book book) {
        if (book.getName() == null || book.getAuthor() == null || book.getPublicationDate() == null){
            throw new ApiException("Can not Empty");
        }
        this.bookRepo.save(book);
        return "Done!";
    }
    @Override
    public String deleteBook(String id) {
        if (this.findBookById(id).equals(new Book())){
            throw  new ApiException("Book Not Exist");
        }
        this.bookRepo.deleteById(id);
        return "Delete success";
    }

    @Override
    public String updateBook(String id, Book book) {
        if (book.getName() == null || book.getAuthor() == null || book.getPublicationDate() == null){
            throw new ApiException("Can not Empty");
        }
        Book bookDB = this.findBookById(id);
        bookDB.setName(book.getName());
        bookDB.setAuthor(book.getAuthor());
        bookDB.setPublicationDate(book.getPublicationDate());
        bookDB.setDescribe((book.getDescribe()));
        this.bookRepo.save(bookDB);
        return "Done!";
    }


    @Override
    public List<Book> findBookByDate(Date start, Date end) {
        if (start.after(end)){
            throw new ApiException("start Date < end Date");

        }
        Pageable pageable = PageRequest.of(0,5, Sort.by("publicationDate").descending());
        Page<Book> pageResult = bookRepo.findBookByPublicationDateBetween(start,end, pageable);
        return pageResult.toList();
    }

    @Override
    public List<Book> findByText(String author) {
        return this.bookRepo.findByText(author);
    }

    @Override
    public List<Book> getAllBook(int page, int size) {
        if (page < 0){
            throw new ApiException("page >= 0");
        } else if (size < 1) {
            throw new ApiException("size > 1");
        }
        else {
            Pageable paging = PageRequest.of(page,size, Sort.by("publicationDate").descending());
            Page<Book> pageResult = bookRepo.findAll(paging);
            return pageResult.toList();
        }
    }
}
