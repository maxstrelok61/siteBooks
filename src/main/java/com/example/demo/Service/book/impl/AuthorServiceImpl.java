package com.example.demo.Service.book.impl;

import com.example.demo.Model.Status;
import com.example.demo.Model.book.Author;
import com.example.demo.Model.book.Tag;
import com.example.demo.Service.book.AuthorService;
import com.example.demo.repository.book.AuthorRepository;
import com.example.demo.repository.book.BookRepository;
import com.example.demo.repository.book.CycleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;
    private final CycleRepository cycleRepository;
    private final BookRepository bookRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository, CycleRepository cycleRepository, BookRepository bookRepository){
        this.authorRepository = authorRepository;
        this.cycleRepository = cycleRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public Author save(Author a) {
        return authorRepository.save(a);
    }

    @Override
    public Author findById(Long id) {
        return authorRepository.findById(id).orElse(null);
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll_Active();
    }

    @Override
    public List<Author> strToAuthor(List<String> list) {
        List<Author> listAuthors = new ArrayList<>();
        Author tmp;
        for (int i = 0; i < list.size(); i++) {
            tmp = authorRepository.findByName(list.get(i));
            if (tmp == null) {
                tmp = new Author(list.get(i));
                tmp.setStatus(Status.ACTIVE);
                save(tmp);
            }
            listAuthors.add(tmp);
        }
        return listAuthors;
    }


}
