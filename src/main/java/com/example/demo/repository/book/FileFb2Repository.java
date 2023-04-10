package com.example.demo.repository.book;

import com.example.demo.Model.book.Book;
import com.example.demo.Model.book.FileEpub;
import com.example.demo.Model.book.FileFb2;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileFb2Repository   extends JpaRepository<FileFb2, Long> {
    FileFb2 findByBook(Book book);
}
