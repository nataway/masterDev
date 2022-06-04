package com.example.restapi_masterdev.Controller;

import com.example.restapi_masterdev.Service.Implement.userImplement;
import com.example.restapi_masterdev.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class userController {
    @Autowired
    private userImplement userservice;

    @GetMapping("/find/{id}")
    public ResponseEntity<User> find(@PathVariable("id") int id){
        return new ResponseEntity<>(userservice.findById(id), HttpStatus.OK);
    }
    @GetMapping("/all")
    public ResponseEntity<List<User>> getAll(){
        List<User> users = userservice.getAll();
        return new  ResponseEntity<>(users, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") int id){
        String mess = userservice.deleteUser(id);
        return new ResponseEntity<>(mess, HttpStatus.OK);
    }
    @PutMapping("/updateUser/{id}")
    public ResponseEntity<String> updateUser(@PathVariable("id") int id, @RequestBody User user){
         String mess = userservice.updateUser(id,user);
        return new ResponseEntity<>(mess, HttpStatus.OK);
    }
    @PostMapping("/addUser")
    public ResponseEntity<String> addUser(@RequestBody User user){
        String mess = userservice.addUser(user);
        return new ResponseEntity<>(mess, HttpStatus.CREATED);
    }
}
