package com.example.demo.Service.book.impl;

import com.example.demo.Model.Status;
import com.example.demo.Model.book.Book;
import com.example.demo.Model.book.FileEpub;
import com.example.demo.Service.book.FileEpubService;
import com.example.demo.repository.book.FileEpubRepository;
import com.example.demo.repository.book.FileMobiRepository;
import org.springframework.stereotype.Service;

@Service
public class FileEpubServiceImpl implements FileEpubService {

    FileEpubRepository epubRepository;

    public FileEpubServiceImpl(FileEpubRepository epubRepository){
        this.epubRepository = epubRepository;
    }

    @Override
    public FileEpub save( FileEpub epub) {
        FileEpub res = null;
        FileEpub epub_temp = epubRepository.findByBook(epub.getBook());
        if (epub_temp == null){
            epub.setStatus(Status.ACTIVE);
            res = epubRepository.save(epub);
        }else{
            epub_temp.setNameFile(epub.getNameFile());
            res = epub_temp;
            epubRepository.save(res);
        }
        return res;
    }

    @Override
    public FileEpub findByBook(Book book) {
        return epubRepository.findByBook(book);
    }
}
