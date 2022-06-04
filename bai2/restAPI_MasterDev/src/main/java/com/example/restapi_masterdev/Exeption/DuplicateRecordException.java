package com.example.restapi_masterdev.Exeption;

public class DuplicateRecordException extends RuntimeException{
    public DuplicateRecordException(String message){
        super(message);
    }
}
