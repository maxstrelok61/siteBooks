package com.example.demo.Model.book;

import com.example.demo.Model.BaseEntity;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="fb2")
@Data
public class FileFb2 extends BaseEntity {

    @Column(name = "nameFile")
    private String nameFile ;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Book book;

    public FileFb2(){}
    public FileFb2(String nameFile, Book book){this.nameFile = nameFile; this.book = book;}

}
