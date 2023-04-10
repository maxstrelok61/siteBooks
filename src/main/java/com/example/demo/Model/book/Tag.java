package com.example.demo.Model.book;

import com.example.demo.Model.BaseEntity;
import com.example.demo.Model.Status;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="tag")
@Data
public class Tag extends BaseEntity {

    @Column(name = "name")
    private String name;

    @ManyToMany
    List<Book> books = new ArrayList<>();


    public Tag(){}
    public Tag(String name){
        this.name = name;
        this.setStatus(Status.ACTIVE);
    }

}


