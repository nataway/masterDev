package com.example.restapi_masterdev.Service;


import com.example.restapi_masterdev.Model.User;
import org.hibernate.service.Service;

import java.util.List;

public interface userService extends Service {
    List<User> getAll();
    User findById(int id);
    Boolean checkEmail(String email);
    String addUser(User u);
    String deleteUser(int id);
    String updateUser(int id, User user);



}
