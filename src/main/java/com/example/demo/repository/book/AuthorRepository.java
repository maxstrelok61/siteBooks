package com.example.demo.repository.book;

import com.example.demo.Model.book.Author;
import com.example.demo.Model.book.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AuthorRepository   extends JpaRepository<Author, Long> {
    @Query("select a from Author a where a.name = :name and a.status = 'ACTIVE'")
    Author findByName(@Param("name")String name);

    @Query("select a from Author a where a.status = 'ACTIVE'")
    List<Author> findAll_Active();

    @Query("select a from Author a")
    List<Author> findAll_All();

    @Query("select a from Author a where a.status = 'DELETED'")
    List<Author> findAll_Deleted();
}
