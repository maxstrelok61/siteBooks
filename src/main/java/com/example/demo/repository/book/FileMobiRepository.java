package com.example.demo.repository.book;

import com.example.demo.Model.book.Book;
import com.example.demo.Model.book.FileFb2;
import com.example.demo.Model.book.FileMobi;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileMobiRepository extends JpaRepository<FileMobi, Long> {
    FileMobi findByBook(Book book);
}
