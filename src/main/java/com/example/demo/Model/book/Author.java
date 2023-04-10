package com.example.demo.Model.book;

import com.example.demo.Model.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="author")
@Data
public class Author extends BaseEntity {

    @Column(name = "name")
    private String name;


    @ManyToMany
    List<Book> books = new ArrayList<>();


    public Author (){}
    public Author (String name){
        this.name = name;
    }


}
