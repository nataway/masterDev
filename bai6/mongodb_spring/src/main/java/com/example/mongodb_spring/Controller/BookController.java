package com.example.mongodb_spring.Controller;


import com.example.mongodb_spring.Model.Book;
import com.example.mongodb_spring.Service.Implement.BookImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @DeleteMapping("deleteBook/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable("id") String id){
        return new ResponseEntity<>(bookimpl.deleteBook(id), HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Book> findBook(@PathVariable("id") String id){
        return new ResponseEntity<>(bookimpl.findBookById(id), HttpStatus.OK);
    }

    @PutMapping("/updateBook/{id}")
    public ResponseEntity<String> updateBook(@PathVariable("id") String id, @RequestBody Book book){
        return new ResponseEntity<>(bookimpl.updateBook(id,book), HttpStatus.OK);
    }

    @GetMapping("/findBookByDate")
    public ResponseEntity<List<Book>> findBookByDate(@RequestParam("start") @DateTimeFormat(pattern="yyyy-MM-dd") Date start,
                                                     @RequestParam("end") @DateTimeFormat(pattern="yyyy-MM-dd") Date end){
        return new ResponseEntity<>(bookimpl.findBookByDate(start,end), HttpStatus.OK);
    }

    @GetMapping("/findByText/{Text}")
    public ResponseEntity<List<Book>> findByText(@PathVariable("Text")  String Text){
        return new ResponseEntity<>(bookimpl.findByText(Text), HttpStatus.OK);
    }
    @GetMapping("/getAllBook/{page}/{size}")
    public ResponseEntity<List<Book>> findAllBook(@PathVariable("page") int page,
                                                  @PathVariable("size") int size){
        return new ResponseEntity<>(bookimpl.getAllBook(page,size),HttpStatus.OK);
    }

}
