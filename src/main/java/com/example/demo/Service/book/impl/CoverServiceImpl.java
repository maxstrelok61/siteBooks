package com.example.demo.Service.book.impl;

import com.example.demo.Model.book.Book;
import com.example.demo.Model.book.Cover;
import com.example.demo.Service.book.CoverService;
import com.example.demo.repository.book.CoverRepository;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

@Service
public class CoverServiceImpl implements CoverService {
    private final CoverRepository coverRepository;

    public CoverServiceImpl(CoverRepository coverRepository){
        this.coverRepository = coverRepository;
    }

    @Override
    public Cover save(Cover c) {
        Cover res = null;
        Cover cover_temp = coverRepository.findByBook(c.getBook());
        if (cover_temp == null) res = coverRepository.save(c);
            else {
                cover_temp.setNameFile(c.getNameFile());
                res = cover_temp;
                coverRepository.save(res);
        }
        return res;
    }

    @Override
    public Cover findByBook(Book book) {
        Cover c = coverRepository.findByBook(book);
        return checkCover(c);
    }

    @Override
    public List<Cover> findAllByBooks(List<Book> books) {
        List<Cover> lc = coverRepository.findAllByBooks(books);
        for (int i = 0; i < lc.size(); i++) {
            lc.set(i, checkCover(lc.get(i)));
        }
        return lc;
    }

    public Cover checkCover(Cover c){
        if (c == null) return null;
        File f = new File("src/main/webapp/res/img/" + c.getNameFile());
        if (!f.exists()) {
            c.setNameFile("NoneBookImg.jpg");
            c = save(c);
        }
        return c;
    }
}
