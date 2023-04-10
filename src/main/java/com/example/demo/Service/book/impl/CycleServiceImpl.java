package com.example.demo.Service.book.impl;

import com.example.demo.Model.Status;
import com.example.demo.Model.book.Book;
import com.example.demo.Model.book.Cycle;
import com.example.demo.Service.book.CycleService;
import com.example.demo.repository.book.AuthorRepository;
import com.example.demo.repository.book.BookRepository;
import com.example.demo.repository.book.CycleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CycleServiceImpl implements CycleService {

    private final CycleRepository cycleRepository;
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public CycleServiceImpl(CycleRepository cycleRepository,
                            BookRepository bookRepository,
                            AuthorRepository authorRepository){
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.cycleRepository = cycleRepository;

    }

    @Override
    public Cycle save(Cycle c) {
        return cycleRepository.save(c);
    }

    @Override
    public Cycle findById(Long id) {
        return cycleRepository.findById(id).orElse(null);
    }

    @Override
    public Cycle findByBook(Book book) {
        return cycleRepository.findCyleByBook(book);
    }

    @Override
    public Cycle fyndCycleByName(String name) {
        Cycle c = cycleRepository.findCyleByName(name);
        if (c == null) {
            c = new Cycle(name);
            c.setStatus(Status.ACTIVE);
        }
        return c;
    }

    @Override
    public List<Cycle> findAll() {
        return cycleRepository.findAll();
    }
}
