package com.example.demo.Service.book;

import com.example.demo.Model.book.Author;
import com.example.demo.Model.book.Book;
import com.example.demo.Model.book.Tag;

import java.util.List;

public interface AuthorService {
    Author save(Author a);
    Author  findById(Long id);
    List<Author> findAll();

    List<Author> strToAuthor(List<String> list);
}
