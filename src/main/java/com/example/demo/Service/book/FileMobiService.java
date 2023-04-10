package com.example.demo.Service.book;

import com.example.demo.Model.book.Book;
import com.example.demo.Model.book.FileFb2;
import com.example.demo.Model.book.FileMobi;

public interface FileMobiService {
    FileMobi save(FileMobi mobi);
    FileMobi  findByBook(Book book);

}
