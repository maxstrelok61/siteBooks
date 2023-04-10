package com.example.demo.Service.book;

import com.example.demo.Model.book.Book;
import com.example.demo.Model.book.FileEpub;
import com.example.demo.Model.book.FileFb2;
import com.example.demo.Model.book.FileMobi;

public interface FileFb2Service {
    FileFb2 save(FileFb2 mobi);
    FileFb2  findByBook(Book book);

}
