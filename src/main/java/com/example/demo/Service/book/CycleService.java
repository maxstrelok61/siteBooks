package com.example.demo.Service.book;

import com.example.demo.Model.book.Book;
import com.example.demo.Model.book.Cycle;
import com.example.demo.Model.book.Genre;

import java.util.List;

public interface CycleService {
    Cycle save(Cycle c);
    Cycle findById(Long id);
    Cycle findByBook(Book book);
    Cycle fyndCycleByName(String name);
    List<Cycle> findAll();
}
