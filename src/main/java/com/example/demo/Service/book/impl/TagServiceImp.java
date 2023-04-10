package com.example.demo.Service.book.impl;

import com.example.demo.Model.Status;
import com.example.demo.Model.book.Book;
import com.example.demo.Model.book.Genre;
import com.example.demo.Model.book.Tag;
import com.example.demo.Service.book.TagService;
import com.example.demo.repository.book.BookRepository;
import com.example.demo.repository.book.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class TagServiceImp implements TagService {

    private final TagRepository tagRepository;
    private final BookRepository bookRepository;

    @Autowired
    public TagServiceImp(TagRepository tagRepository, BookRepository bookRepository){
        this.tagRepository = tagRepository;
        this.bookRepository = bookRepository;
    }


    @Override
    public Tag save(Tag t) {
        return tagRepository.save(t);
    }

    @Override
    public Tag findById(Long id) {
        return tagRepository.findById(id).orElse(null);
    }

    @Override
    public List<Tag> findAll() {
        return tagRepository.findAll();
    }

    @Override
    public List<Tag> strToTags(List<String> list) {

        List<Tag> listTags = new ArrayList<>();
        Tag tmp;
        for (int i = 0; i < list.size(); i++) {
            tmp = tagRepository.findByName(list.get(i));
            if (tmp == null) {
                if (!list.get(i).equals("")) {
                    tmp = new Tag(list.get(i));
                    tmp.setStatus(Status.ACTIVE);
                    save(tmp);
                }
            }
            listTags.add(tmp);
        }
        return listTags;
    }
}
