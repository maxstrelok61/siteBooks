package com.example.demo.Service.book;

import com.example.demo.Model.book.Tag;

import java.util.List;

public interface TagService {
    Tag save(Tag t);
    Tag findById(Long id);
    List<Tag> findAll();
    List<Tag> strToTags(List<String> list);
}
