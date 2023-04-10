package com.example.demo.Model.book;

import com.example.demo.Model.BaseEntity;
import com.example.demo.Model.Status;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="book")
@Data
public class Book extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "statusBook")
    private StatusBook statusBook;

    @Enumerated(EnumType.STRING)
    @Column(name = "visebleBook")
    private VisebleBook visebleBook;

    @ManyToMany
    @JoinTable(
            name = "book_author",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    List<Author> authors = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "book_genres",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    List<Genre> genres = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "book_tags",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    List<Tag> tags = new ArrayList<>();

    public Book(){}
    public Book(String name, String description, List<Author> authors, List<Genre> genres, List<Tag> tags){
        this.name = name;
        this.description = description;
        addTag(tags);
        addGenre(genres);
        addAuthor(authors);

        this.setStatus(Status.ACTIVE);
        this.setVisebleBook(VisebleBook.PRIVATE);
        this.setStatusBook(StatusBook.ENDED);
    }
    public Book(String name, String description, List<Author> authors, List<Genre> genres, List<Tag> tags, Status status, StatusBook statusBook, VisebleBook visebleBook){
        this.name = name;
        this.description = description;
        addTag(tags);
        addGenre(genres);
        addAuthor(authors);

        this.setStatus(status);
        this.setVisebleBook(visebleBook);
        this.setStatusBook(statusBook);
    }
    public void setAtributeBook(String name, String description, List<Author> authors, List<Genre> genres, List<Tag> tags, Status status, StatusBook statusBook, VisebleBook visebleBook){
        this.name = name;
        this.description = description;

        this.tags = tags;
        this.authors = authors;
        this.genres = genres;

//        addTag(tags);
//        addGenre(genres);
//        addAuthor(authors);

        this.setStatus(status);
        this.setVisebleBook(visebleBook);
        this.setStatusBook(statusBook);
    }
    public void addAuthor(Author author){
        this.authors.add(author);
    }
    public void addAuthor(List<Author> authors){
        addListAuthors(authors);
    }
    public void addGenre(Genre genre){
        this.genres.add(genre);
    }
    public void addGenre(List<Genre> genres){
        addListGenres(genres);
    }
    public void addTag(Tag tag){
        this.tags.add(tag);
    }
    public void addTag(List<Tag> tags){
            addListTags(tags);
    }
    //--------------------------------------------------------------------------------------
    private void addListAuthors(List<Author> authors){
        if (authors != null){
            for (int i = 0; i < authors.size(); i++) {
                if (!checkAuthor(this.authors,authors.get(i))) addAuthor(authors.get(i));
            }
        }
    }
    private void addListGenres(List<Genre> genres){
        if (genres != null){
            for (int i = 0; i < genres.size(); i++) {
                if(!checkGenre(this.genres, genres.get(i))) addGenre(genres.get(i));
            }
        }
    }
    private void addListTags(List<Tag> tags){
        if (tags != null) {
            for (int i = 0; i < tags.size(); i++) {
                if (!checkTag(this.tags, tags.get(i))) addTag(tags.get(i));
            }
        }
    }

    private boolean checkAuthor(List<Author> authors, Author author){
        boolean res = false;
        for (int i = 0; i < authors.size(); i++) {
            if (authors.get(i).getId() == author.getId()) res = true;
        }
        return res;
    }

    private boolean checkGenre(List<Genre> genres, Genre genre){
        boolean res = false;
        for (int i = 0; i < genres.size(); i++) {
            if (genres.get(i).getId() == genre.getId()) res = true;
        }
        return res;
    }

    private boolean checkTag(List<Tag> tags, Tag tag){
        boolean res = false;
        for (int i = 0; i < tags.size(); i++) {
            if (tags.get(i).getId() == tag.getId()) res = true;
        }
        return res;
    }

}
