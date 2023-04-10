package com.example.demo.Service.book;

import com.example.demo.Model.book.Author;
import com.example.demo.Model.book.Book;
import com.example.demo.Model.book.Cover;
import com.example.demo.Model.book.FileEpub;
import com.example.demo.repository.book.CoverRepository;
import com.example.demo.repository.book.CycleRepository;

import java.util.List;

public interface CoverService {
    Cover save(Cover c);
    Cover  findByBook(Book book);

    List<Cover> findAllByBooks (List<Book> books);

}
