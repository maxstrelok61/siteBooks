package com.example.demo.Model.user;

import com.example.demo.Model.BaseEntity;
import com.example.demo.Model.book.Book;
import com.example.demo.Model.book.StatusBook;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="role")
@Data
public class Role extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(name = "name")
    private StatusRole name;

    @ManyToMany
    List<User> users = new ArrayList<>();
}
