package com.example.demo.repository.book;

import com.example.demo.Model.book.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BookRepository  extends JpaRepository<Book, Long> {

//    @Query("select b from Book b where 'id' = :id")
//    Optional<Book> findById(@Param("id")Long id);

    Book findByName(String name);

    @Query("select b from Book b join b.tags t where t in :tags and b.status = 'ACTIVE'")
    List<Book> findAllByTag(@Param("tags") List<Tag> tags);

    @Query("select b from Book b join b.genres g where g in :genres and b.status = 'ACTIVE'")
    List<Book> findAllByGenre(@Param("genres") List<Genre> genres);

    @Query("select b from Book b join b.authors a where a in :authors and b.status = 'ACTIVE'")
    List<Book> findAllByAuthor(@Param("authors") List<Author> authors);

    @Query("select b from Book b join b.authors a join b.genres g join b.tags t where a in :authors and g in :genres and t in :tags and b.status = 'ACTIVE'")
    List<Book> findAllByAGT(@Param("authors") List<Author> authors, @Param("genres") List<Genre> genres, @Param("tags") List<Tag> tags);

    @Query("select b from Book b join b.authors a join b.genres g where a in :authors and g in :genres and b.status = 'ACTIVE'")
    List<Book> findAllByAG(@Param("authors") List<Author> authors, @Param("genres") List<Genre> genres);

    @Query("select b from Book b join b.authors a join b.tags t where a in :authors and t in :tags and b.status = 'ACTIVE'")
    List<Book> findAllByAT(@Param("authors") List<Author> authors, @Param("tags") List<Tag> tags);

    @Query("select b from Book b join b.genres g join b.tags t where g in :genres and t in :tags and b.status = 'ACTIVE'")
    List<Book> findAllByGT(@Param("genres") List<Genre> genres, @Param("tags") List<Tag> tags);

    @Query("select b from Book b join b.genres g where g in :genres and b.status = 'ACTIVE'")
    List<Book> findAllByG(@Param("genres") List<Genre> genres);

    @Query("select b from Book b join b.tags t where t in :tags and b.status = 'ACTIVE'")
    List<Book> findAllByT(@Param("tags") List<Tag> tags);

    @Query("select b from Book b join b.authors a where a in :authors and b.status = 'ACTIVE'")
    List<Book> findAllByAT(@Param("authors") List<Author> authors);

}
