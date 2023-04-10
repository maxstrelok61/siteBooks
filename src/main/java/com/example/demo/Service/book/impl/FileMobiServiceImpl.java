package com.example.demo.Service.book.impl;

import com.example.demo.Model.Status;
import com.example.demo.Model.book.Book;
import com.example.demo.Model.book.FileMobi;
import com.example.demo.Service.book.FileMobiService;
import com.example.demo.repository.book.FileMobiRepository;
import org.springframework.stereotype.Service;

@Service
public class FileMobiServiceImpl implements FileMobiService {

    FileMobiRepository mobiRepository;

    public FileMobiServiceImpl(FileMobiRepository mobiRepository){
        this.mobiRepository = mobiRepository;
    }

    @Override
    public FileMobi save(FileMobi mobi) {
        FileMobi res = null;
        FileMobi fileMobi_temp = mobiRepository.findByBook(mobi.getBook());

        if (fileMobi_temp == null) {
            mobi.setStatus(Status.ACTIVE);
            res = mobiRepository.save(mobi);
        }else{
            fileMobi_temp.setNameFile(mobi.getNameFile());
            res = fileMobi_temp;
            mobiRepository.save(res);
        }
        return res;
    }

    @Override
    public FileMobi findByBook(Book book) {
        return mobiRepository.findByBook(book);
    }
}
