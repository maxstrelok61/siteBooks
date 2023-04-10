package com.example.demo.Service.book;

import com.example.demo.Model.book.Book;
import com.example.demo.Model.book.FileEpub;
import com.example.demo.Model.book.FileFb2;

public interface FileEpubService {
    FileEpub save(FileEpub mobi);
    FileEpub  findByBook(Book book);
}
