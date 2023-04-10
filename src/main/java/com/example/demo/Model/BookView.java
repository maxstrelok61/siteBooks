package com.example.demo.Model;

import com.example.demo.Model.book.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class BookView {
    Book book ;

    Cycle cycle;
    Cover cover;
    FileEpub fileEpub;
    FileFb2 fileFb2;
    FileMobi fileMobi;

    public BookView(){}
    public BookView(Book book){this.book = book;}
    public BookView(Book book, Cover cover, FileEpub fileEpub, FileFb2 fileFb2, FileMobi fileMobi){
        this.book = book;
        this.cover = cover;
        this.fileEpub = fileEpub;
        this.fileFb2  = fileFb2;
        this.fileMobi = fileMobi;
    }

    public List<Tag> getStringTags_card(){
        List<Tag> temp = new ArrayList<>();

        for (int i = 0; i < book.getTags().size(); i++) {
            if (i > 1) break;
            temp.add(book.getTags().get(i));
        }
        return temp;
    }

    public List<Genre> getStringGenres_card(){
        List<Genre> temp = new ArrayList<>();

        for (int i = 0; i < book.getGenres().size(); i++) {
            if (i > 1) break;
            temp.add(book.getGenres().get(i));
        }
        return temp;
    }

    public List<Author> getStringAuthors_card(){
        List<Author> temp = new ArrayList<>();

            temp.add(book.getAuthors().get(0));

        return temp;
    }
}
