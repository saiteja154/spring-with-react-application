package com.example.springbootwithreactcrudoperations.exception;

public class UserNotFoundException extends  RuntimeException{

    public UserNotFoundException(Long id){
        super("User Not Found with ID: "+id);
    }
}
