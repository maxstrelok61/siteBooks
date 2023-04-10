package com.example.demo.Model.book;

import com.example.demo.Model.BaseEntity;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="epub")
@Data
public class FileEpub extends BaseEntity {

    @Column(name = "nameFile")
    private String nameFile ;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Book book;

    public FileEpub(){}
    public FileEpub(String nameFile, Book book){this.nameFile = nameFile; this.book = book;}

}
