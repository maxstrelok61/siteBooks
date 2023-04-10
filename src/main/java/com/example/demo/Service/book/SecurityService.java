package com.example.demo.Service.book;

public interface SecurityService  {

    String findLoggedInUsername();

    void autoLogin(String username, String password);
}