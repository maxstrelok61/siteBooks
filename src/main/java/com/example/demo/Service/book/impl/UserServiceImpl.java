package com.example.demo.Service.book.impl;

import com.example.demo.Model.Status;
import com.example.demo.Model.user.Role;
import com.example.demo.Model.user.StatusRole;
import com.example.demo.Model.user.User;
import com.example.demo.Service.book.UserService;
import com.example.demo.repository.user.UserRepository;
import com.example.demo.repository.user.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public User register(User user) {
        Role roleUser = roleRepository.findByName(StatusRole.USER);
        List<Role> userRoles = new ArrayList<>();
        userRoles.add(roleUser);

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(userRoles);
        user.setStatus(Status.ACTIVE);

        User registeredUser = userRepository.save(user);

        //log.info("IN register - user: {} successfully registered", registeredUser);

        return registeredUser;
    }
    @Override
    public List<User> getAll() {
        List<User> result = userRepository.findAll();
        //log.info("IN getAll - {} users found", result.size());
        return result;
    }
    @Override
    public User findByUsername(String username) {
        User result = userRepository.findByLogin(username);
//        log.info("IN findByUsername - user: {} found by username: {}", result, username);
        return result;
    }

    @Override
    public User findById(Long id) {
        User result = userRepository.findById(id).orElse(null);

        if (result == null) {
//            log.warn("IN findById - no user found by id: {}", id);
            return null;
        }

//        log.info("IN findById - user: {} found by id: {}", result);
        return result;
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
//        log.info("IN delete - user with id: {} successfully deleted");
    }

    @Override
    public User save(User user) {

        if (user.getId() > 0) {
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        }

        return userRepository.save(user);
    }

}
