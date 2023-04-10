package com.example.demo.Service.book.impl;

import com.example.demo.Model.Status;
import com.example.demo.Model.book.Author;
import com.example.demo.Model.book.Book;
import com.example.demo.Model.book.Genre;
import com.example.demo.Model.book.Tag;
import com.example.demo.Service.book.GenreService;
import com.example.demo.repository.book.BookRepository;
import com.example.demo.repository.book.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {

    private final GenreRepository genreRepository;
    private final BookRepository bookRepository;

    @Autowired
    public GenreServiceImpl(GenreRepository genreRepository, BookRepository bookRepository){
        this.genreRepository = genreRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public Genre save(Genre g) {
        return genreRepository.save(g);
    }

    @Override
    public Genre findById(Long id) {
        return genreRepository.findById(id).orElse(null);
    }

    @Override
    public List<Genre> findAll() {
        return genreRepository.findAll();
    }

    @Override
    public List<Genre> strToGenres(List<String> list) {
        List<Genre> listGenres = new ArrayList<>();
        Genre tmp;
        for (int i = 0; i < list.size(); i++) {
            tmp = genreRepository.findByName(list.get(i));
            if (tmp == null) {
                tmp = new Genre(list.get(i));
                tmp.setStatus(Status.ACTIVE);
                save(tmp);
            }
            listGenres.add(tmp);
        }
        return listGenres;
    }
}
