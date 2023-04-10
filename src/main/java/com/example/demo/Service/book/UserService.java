package com.example.demo.Service.book;

import com.example.demo.Model.user.User;

import java.util.List;

public interface UserService {
    User register(User user);

    List<User> getAll();

    User findByUsername(String username);

    User findById(Long id);

    void delete(Long id);
    User save(User user);
}
