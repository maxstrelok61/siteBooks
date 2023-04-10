package com.example.demo.repository.book;

import com.example.demo.Model.book.Book;
import com.example.demo.Model.book.Cycle;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CycleRepository   extends JpaRepository<Cycle, Long> {
    Cycle findByName(String name);

    //@Query("select c from Cycle c join c.tags t where t in :tags")
    @Query("select c from Cycle c where c = :cycle and c.status = 'ACTIVE'")
    List<Book> findBooksByCycle (@Param("cycle") Cycle cycle);

    @Query("select c from Cycle c join c.books b where b = :book and c.status = 'ACTIVE'")
    Cycle findCyleByBook (@Param("book") Book book);

    @Query("select c from Cycle c where c.name = :name and c.status = 'ACTIVE'")
    Cycle findCyleByName (@Param("name") String name);
}
