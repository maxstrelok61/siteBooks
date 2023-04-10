package com.example.demo.Model.user;

import com.example.demo.Model.BaseEntity;
import com.example.demo.Model.book.Author;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="user")
@Data
public class User extends BaseEntity {

    @Column
    private String login;
    @Column
    private String password;
    @Column
    private String fio;

    @ManyToMany
    @JoinTable(
            name = "roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    List<Role> roles = new ArrayList<>();
}
