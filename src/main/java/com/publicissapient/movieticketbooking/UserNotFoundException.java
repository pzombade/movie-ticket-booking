package com.publicissapient.movieticketbooking;

public class UserNotFoundException extends Exception{

    public UserNotFoundException(String msg){
        super("User not found with id " + msg);
    }
}
