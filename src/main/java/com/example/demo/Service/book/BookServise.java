package com.example.demo.Service.book;

import com.example.demo.Model.book.Author;
import com.example.demo.Model.book.Book;
import com.example.demo.Model.book.Genre;
import com.example.demo.Model.book.Tag;

import java.util.List;

public interface BookServise {
    Book save(Book b);
    Book  findById(Long id);
    List<Book> findAll();
    List<Book> findBy(List<Author> authors, List<Genre> genres, List<Tag> tags);
    List<Book> findAllByFiltr(String name, List<Genre> genres,List<Tag> tags);

}
