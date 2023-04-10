package com.example.demo.repository.book;

import com.example.demo.Model.book.Book;
import com.example.demo.Model.book.Cycle;
import com.example.demo.Model.book.FileEpub;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileEpubRepository  extends JpaRepository<FileEpub, Long> {
    FileEpub findByBook(Book book);
}
