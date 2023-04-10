package com.example.demo.Service.book.impl;

import com.example.demo.Model.Status;
import com.example.demo.Model.book.Book;
import com.example.demo.Model.book.FileFb2;
import com.example.demo.Service.book.FileFb2Service;
import com.example.demo.repository.book.FileFb2Repository;
import com.example.demo.repository.book.FileMobiRepository;
import org.springframework.stereotype.Service;

@Service
public class FileFb2ServiceImpl implements FileFb2Service {

    FileFb2Repository fb2Repository;

    public FileFb2ServiceImpl(FileFb2Repository fb2Repository){
        this.fb2Repository = fb2Repository;
    }

    @Override
    public FileFb2 save(FileFb2 fb2) {
        FileFb2 res = null;
        FileFb2 fb2_temp = fb2Repository.findByBook(fb2.getBook());
        if (fb2_temp == null) {
            fb2.setStatus(Status.ACTIVE);
            res = fb2Repository.save(fb2);
        }else{
            fb2_temp.setNameFile(fb2.getNameFile());
            res = fb2_temp;
            fb2Repository.save(res);
        }


        return res;
    }

    @Override
    public FileFb2 findByBook(Book book) {
        return fb2Repository.findByBook(book);
    }
}
