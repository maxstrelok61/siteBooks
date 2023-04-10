package com.example.demo.Model.book;


import com.example.demo.Model.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="cycle")
@Data
public class Cycle extends BaseEntity {

    @Column(name = "name")
    private String name;

    @OneToMany(cascade =  CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "cyle_id")
    private List<Book> books = new ArrayList<>();

    public Cycle(){}
    public Cycle(String name){
        this.name = name;
    }
    public void  addBook (Book book){
        books.add(book);
    }
}
