package com.example.demo.Dto;

import com.example.demo.Model.user.StatusRole;
import com.example.demo.Model.user.User;
import com.example.demo.Service.book.UserService;
import lombok.Data;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;


@Data
public class dtoUser {
    Long id;
    String username;
    String password;
    String fio;
    String role;


    public dtoUser(){
        this.id = 0L;
    }
    public dtoUser(Authentication auth, UserService userService){
        username = auth.getName();

        if (auth.getAuthorities().toString().indexOf(StatusRole.USER.name()) > -1) role = StatusRole.USER.name();
        if (auth.getAuthorities().toString().indexOf(StatusRole.ADMIN.name()) > -1) role = StatusRole.ADMIN.name();

//        System.out.println(role);
//        System.out.println(auth.getAuthorities().toString());

        User u = userService.findByUsername(username);
        if (u != null) {
            fio = u.getFio();
            id = u.getId();
        }
//        auth.getAuthorities().
    }
}
