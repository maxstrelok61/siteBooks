package com.example.demo.repository.book;

import com.example.demo.Model.book.Book;
import com.example.demo.Model.book.Genre;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GenreRepository   extends JpaRepository<Genre, Long> {
    Genre findByName(String name);
}
