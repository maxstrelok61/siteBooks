package com.example.demo.Service.book.impl;

import com.example.demo.Model.book.*;
import com.example.demo.Service.book.BookServise;
import com.example.demo.repository.book.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static org.hibernate.criterion.Restrictions.or;

@Service
public class BookServiseImpl implements BookServise {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final CycleRepository cycleRepository;
    private final GenreRepository genreRepository;
    private final TagRepository tagRepository;

    @Autowired
    public BookServiseImpl(AuthorRepository authorRepository,
                           BookRepository bookRepository,
                           CycleRepository cycleRepository,
                           GenreRepository genreRepository,
                           TagRepository tagRepository){

        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.cycleRepository = cycleRepository;
        this.genreRepository = genreRepository;
        this.tagRepository = tagRepository;

    }



    @Override
    public Book save(Book b) {
        return bookRepository.save(b);

    }

    @Override
    public Book findById(Long id) {
        Book b = bookRepository.findById(id).orElse(null);
        return  b;
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public List<Book> findAllByFiltr(String name, List<Genre> genres,List<Tag> tags){
        boolean b_name = false;
        boolean b_genre = false;
        boolean b_tag = false;

        List<Book> books = null;
        List<Book> booksRes = new ArrayList<>();

        if (name != null){
            if (!name.equals("")) b_name = true;}

        if (genres != null)
            if (genres.get(0) != null)
                if (!genres.get(0).getName().equals("")){b_genre = true;}

        if (tags != null)
            if (tags.get(0) != null)
                if (!tags.get(0).getName().equals("")){
                    b_tag = true;}

        if (b_tag && b_genre) {
            books = bookRepository.findAllByGT(genres, tags);
        } else if (b_tag && !b_genre) {
            books = bookRepository.findAllByT(tags);
        } else if (!b_tag && b_genre) {
            books = bookRepository.findAllByG(genres);
        } else if (!b_genre && !b_tag) books =  findAll();

            if (b_name) {
                for (int i = 0; i < books.size(); i++) {
                    if ((checkBookByName(books.get(i), name)|(checkBookByNameAuthor(books.get(i), name)))){
                        booksRes.add(books.get(i));
                    }
                }
            } else {
                booksRes = books;
            }

        return booksRes;
    }
    private boolean checkBookByName(Book book, String name){
        boolean res = false;
        if (book.getName().indexOf(name) > -1) res = true;
        return res;
    }
    private boolean checkBookByNameAuthor(Book book, String nameAuthor){
        boolean res = false;
        for (int i = 0; i < book.getAuthors().size(); i++) {
            if (book.getAuthors().get(i).getName().indexOf(nameAuthor) > -1) res = true;
        }
        return res;
    }

    @Override
    public List<Book> findBy(List<Author> authors, List<Genre> genres, List<Tag> tags) {
        boolean a = false;
        boolean g = false;
        boolean t = false;

        if ((authors != null)|(authors.size() > 0)) a = true;
        if ((genres != null)|(genres.size() > 0)) g = true;
        if ((tags != null)|(tags.size() > 0)) t = true;


        if (a && g && t) return bookRepository.findAllByAGT(authors,genres,tags);
        if (a && g && !t) return bookRepository.findAllByAG(authors,genres);
        if (a && !g && t) return bookRepository.findAllByAT(authors,tags);
        if (!a && g && t) return bookRepository.findAllByGT(genres,tags);

        return null;
    }
}
