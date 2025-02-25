package com.bridgelabz.employeepayrollapp.coustomexception;

public class UserNotFoundException extends Exception{
    public UserNotFoundException(String message){
        super(message);
    }

}
