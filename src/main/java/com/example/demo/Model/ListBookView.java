package com.example.demo.Model;

import com.example.demo.Model.book.*;

import java.util.ArrayList;
import java.util.List;

public class ListBookView {
    public List<BookView> listBook = new ArrayList<>();

    public ListBookView(){}

    public void addListBook(List<Book> books){
        if (books != null)
            if (!books.isEmpty()){
                if (books.get(0) != null) {
                    for (int i = 0; i < books.size(); i++) {
                        listBook.add(new BookView(books.get(i)));
                    }
                }
            }
    }
    public void addBook(Book book){
        listBook.add(new BookView(book));
    }

    public void addListCover(List<Cover> covers){
        int t;
        for (int i = 0; i < covers.size(); i++) {
            t = findBookId(covers.get(i).getBook().getId());
            if (t > -1) listBook.get(t).setCover(covers.get(i));
        }
    }
    public void addCover(Cover cover){
        int t;
        t = findBookId(cover.getBook().getId());
        if (t > -1) listBook.get(t).setCover(cover);
    }

    public void addListEPUB(List<FileEpub> fileEpubs){
        int t;
        for (int i = 0; i < fileEpubs.size(); i++) {
            t = findBookId(fileEpubs.get(i).getBook().getId());
            if (t > -1) listBook.get(t).setFileEpub(fileEpubs.get(i));
        }
    }
    public void  addEPUB(FileEpub fileEpub){
    int t;
        t = findBookId(fileEpub.getBook().getId());
        if (t > -1) listBook.get(t).setFileEpub(fileEpub);
    }

    public void clear(){
        listBook.clear();
    }
    public void addListFb2(List<FileFb2> fileFb2s){
        int t;
        for (int i = 0; i < fileFb2s.size(); i++) {
            t = findBookId(fileFb2s.get(i).getBook().getId());
            if (t > -1) listBook.get(t).setFileFb2(fileFb2s.get(i));
        }
    }
    public void  addFb2(FileFb2 fileFb2){
        int t;
        t = findBookId(fileFb2.getBook().getId());
        if (t > -1) listBook.get(t).setFileFb2(fileFb2);
    }

    public void addListMobi(List<FileMobi> fileMobis){
        int t;
        for (int i = 0; i < fileMobis.size(); i++) {
            t = findBookId(fileMobis.get(i).getBook().getId());
            if (t > -1) listBook.get(t).setFileMobi(fileMobis.get(i));
        }
    }
    public void  addMobi(FileMobi fileMobi){
        int t;
        t = findBookId(fileMobi.getBook().getId());
        if (t > -1) listBook.get(t).setFileMobi(fileMobi);
    }

    public List<Book> getListBooks(){
        List<Book> books = new ArrayList<>();
        for (int i = 0; i < listBook.size(); i++) {
            books.add(listBook.get(i).getBook());
        }
        return books;
    }
//    public BookView getBookViewById(Long id){
//
//    }
    private int findBookId (Long id){
        int res = -1;
        for (int i = 0; i < listBook.size(); i++) {
            if (listBook.get(i).getBook().getId() == id) res = i;
        }
        return res;
    }
}
