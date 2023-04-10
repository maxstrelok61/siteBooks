package com.example.demo.Model.book;

import com.example.demo.Model.BaseEntity;
import com.example.demo.Model.Status;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="Cover")
@Data
public class Cover extends BaseEntity {
    @Column(name = "nameFile")
    private String nameFile ;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Book book;

    public Cover(){}
    public Cover(String nameFile, Book book){this.nameFile = nameFile; this.book = book;}



}
