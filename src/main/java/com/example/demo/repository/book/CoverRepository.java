package com.example.demo.repository.book;

import com.example.demo.Model.book.Author;
import com.example.demo.Model.book.Book;
import com.example.demo.Model.book.Cover;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CoverRepository   extends JpaRepository<Cover, Long> {
    Cover findByBook(Book book);

    @Query("select c from Cover c join c.book b where b in :books and b.status = 'ACTIVE'")
    List<Cover> findAllByBooks(@Param("books") List<Book> books);
}
