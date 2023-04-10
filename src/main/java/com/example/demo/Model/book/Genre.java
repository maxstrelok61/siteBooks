package com.example.demo.Model.book;

import com.example.demo.Model.BaseEntity;
import com.example.demo.Model.Status;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="genre")
@Data
public class Genre extends BaseEntity {

    @Column(name = "name")
    private String name;

    @ManyToMany
    List<Book> books = new ArrayList<>();


    public Genre(){}
    public Genre(String name){
        this.name=name;
        this.setStatus(Status.ACTIVE);
    }

}
