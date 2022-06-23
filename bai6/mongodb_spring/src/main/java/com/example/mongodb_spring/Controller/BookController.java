package com.example.mongodb_spring.Controller;


import com.example.mongodb_spring.Model.Book;
import com.example.mongodb_spring.Service.Implement.BookImpl;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.text.SimpleDateFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class BookController {
    @Autowired
    private BookImpl bookimpl;

    @PostMapping("/addBook")
    public ResponseEntity<String> addBook(@RequestBody Book book){
        String mess = bookimpl.addBook(book);
        return new ResponseEntity<>(mess, HttpStatus.CREATED);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Book>> getAll(){
        return new ResponseEntity<>(bookimpl.getAll(), HttpStatus.OK);
    }

    @DeleteMapping("deleteBook/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable("id") String id){
        return new ResponseEntity<>(bookimpl.deleteBook(id), HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Book> findBook(@PathVariable("id") String id){
        return new ResponseEntity<>(bookimpl.findBookById(id), HttpStatus.OK);
    }

    @GetMapping("/findByAuthorAndName")
    public ResponseEntity<List<Book>> findByAuthorAndName( @RequestParam("author") String author, @RequestParam("name") String name){
        return new ResponseEntity<>(bookimpl.findByAuthorAndName(author, name), HttpStatus.OK);
    }

    @PutMapping("/updateBook/{id}")
    public ResponseEntity<String> updateBook(@PathVariable("id") String id, @RequestBody Book book){
        return new ResponseEntity<>(bookimpl.updateBook(id,book), HttpStatus.OK);
    }

    @GetMapping("/findBookByDate/{start}/{end}")
    public ResponseEntity<List<Book>> findBookByDate(@PathVariable("start") Date start,
                                                     @PathVariable("end") Date end){
        return new ResponseEntity<>(bookimpl.findBookByDate(start,end), HttpStatus.OK);
    }


}
