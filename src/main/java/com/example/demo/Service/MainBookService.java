package com.example.demo.Service;

import com.example.demo.Model.book.*;
import com.example.demo.Service.book.*;

public interface MainBookService {
    Book updateBook(Book book);
    Genre updateGenre(Genre genre);
    Tag updateTag(Tag tag);
    Cycle updateCycle(Cycle cycle);
    Cover updateCover(Cover cover);
    FileEpub updateFileEpub(FileEpub fileEpub);
    FileFb2 updateFileFb2(FileFb2 fileEpub);
    FileMobi updateFileMobi(FileMobi fileEpub);
    //--------------------------------------------------------------------------------------
    void updateCard(Book book, Cycle cycle, Cover cover, FileEpub fileEpub, FileFb2 fileFb2, FileMobi fileMobi);
    void updateCard(Book book, Cycle cycle, String cover, String fileEpub, String fileFb2, String fileMobi);
}
