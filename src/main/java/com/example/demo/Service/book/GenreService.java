package com.example.demo.Service.book;

import com.example.demo.Model.book.Genre;
import com.example.demo.Model.book.Tag;

import java.util.List;

public interface GenreService {
    Genre save(Genre g);
    Genre findById(Long id);
    List<Genre> findAll();
    List<Genre> strToGenres(List<String> list);
}
