package com.example.restapi_masterdev.Exeption;

public class checkAddUser extends RuntimeException{
    public checkAddUser(String message){
        super(message);
    }
}