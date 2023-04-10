package com.example.demo.Service;

import com.example.demo.Model.Status;
import com.example.demo.Model.book.*;
import com.example.demo.Service.book.*;
import org.springframework.stereotype.Service;

@Service
public class MainBookServiceImpl implements MainBookService{
    private final GenreService genreService;
    private final TagService tagService;
    private final AuthorService authorService;
    private final BookServise bookServise;
    private final CycleService cycleService;
    private final CoverService coverService;
    private final FileEpubService fileEpubService;
    private final FileFb2Service fileFb2Service;
    private final FileMobiService fileMobiService;

    public MainBookServiceImpl(GenreService genreService, TagService tagService, AuthorService authorService, BookServise bookServise, CycleService cycleService, CoverService coverService, FileEpubService fileEpubService, FileFb2Service fileFb2Service, FileMobiService fileMobiService) {
        this.genreService = genreService;
        this.tagService = tagService;
        this.authorService = authorService;
        this.bookServise = bookServise;
        this.cycleService = cycleService;
        this.coverService = coverService;
        this.fileEpubService = fileEpubService;
        this.fileFb2Service = fileFb2Service;
        this.fileMobiService = fileMobiService;
    }

    @Override
    public Book updateBook(Book book) {
        if (book.getVisebleBook() == null) book.setVisebleBook(VisebleBook.PRIVATE);
        if (book.getStatus() == null) book.setStatus(Status.ACTIVE);
        if (book.getStatusBook() == null) book.setStatusBook(StatusBook.ENDED);

        return bookServise.save(book);
    }

    @Override
    public Genre updateGenre(Genre genre) {
        if (genre.getStatus() == null) genre.setStatus(Status.ACTIVE);
        return genreService.save(genre);
    }

    @Override
    public Tag updateTag(Tag tag) {
        if (tag.getStatus() == null) tag.setStatus(Status.ACTIVE);
        return tagService.save(tag);
    }

    @Override
    public Cycle updateCycle(Cycle cycle) {
        if (cycle.getStatus() == null) cycle.setStatus(Status.ACTIVE);
        return cycleService.save(cycle);
    }

    @Override
    public Cover updateCover(Cover cover) {
        if (cover.getStatus() == null) cover.setStatus(Status.ACTIVE);
        return coverService.save(cover);
    }

    @Override
    public FileEpub updateFileEpub(FileEpub fileEpub) {
        if (fileEpub.getStatus() == null) fileEpub.setStatus(Status.ACTIVE);
        return fileEpubService.save(fileEpub);
    }

    @Override
    public FileFb2 updateFileFb2(FileFb2 fileFb2) {
        if (fileFb2.getStatus() == null) fileFb2.setStatus(Status.ACTIVE);
        return fileFb2Service.save(fileFb2);
    }

    @Override
    public FileMobi updateFileMobi(FileMobi fileMobi) {
        if (fileMobi.getStatus() == null) fileMobi.setStatus(Status.ACTIVE);
        return fileMobiService.save(fileMobi);
    }
    public void disabledCover(Book book){
        Cover cover_tmp = coverService.findByBook(book);
        if (cover_tmp == null){
            cover_tmp.setDeativeEl();
        }
    }
    public void disabledEpub(Book book){
        FileEpub epub_tmp = fileEpubService.findByBook(book);
        if (epub_tmp == null){
            epub_tmp.setDeativeEl();
        }
    }
    public void disabledFb2(Book book){
        FileFb2 fb2_tmp = fileFb2Service.findByBook(book);
        if (fb2_tmp == null){
            fb2_tmp.setDeativeEl();
        }
    }
    public void disabledMobi(Book book){
        FileMobi mobi_tmp = fileMobiService.findByBook(book);
        if (mobi_tmp == null){
            mobi_tmp.setDeativeEl();
        }
    }
//--------------------------------------------------------------------------------------------------------------------
    @Override
    public void updateCard(Book book, Cycle cycle, Cover cover, FileEpub fileEpub, FileFb2 fileFb2, FileMobi fileMobi) {
        //System.out.println("updateCard[Obj]");
        Book tempBook =  updateBook(book);
        if (cycle != null) updateCycle(cycle);
        //System.out.println("updateCard[checkCyle]");
        if (cover != null){cover.setBook(tempBook); updateCover(cover);}
        //System.out.println("updateCard[checkCover]");
        if (fileEpub != null){fileEpub.setBook(tempBook); updateFileEpub(fileEpub);}
        //System.out.println("updateCard[checkEpub]");
        if (fileFb2 != null){fileFb2.setBook(tempBook); updateFileFb2(fileFb2);}
        //System.out.println("updateCard[checkFb2]");
        if (fileMobi != null){fileMobi.setBook(tempBook); updateFileMobi(fileMobi);}
        //System.out.println("updateCard[checkMobi]");
    }

    @Override
    public void updateCard(Book book, Cycle cycle, String cover, String fileEpub, String fileFb2, String fileMobi) {
//        System.out.println("updateCard[Str]");
        Cover coverObj = new Cover();
        if (cover != null)
            if(!cover.equals("")) coverObj.setNameFile(cover);
            else coverObj = null;

        FileEpub fileEpubObj = new FileEpub();
        if (fileEpub != null)
            if ((!fileEpub.equals(""))) fileEpubObj.setNameFile(fileEpub);
            else fileEpubObj = null;

        FileFb2 fileFb2Obj = new FileFb2();
        if (fileFb2 != null)
            if (!fileFb2.equals("")) fileFb2Obj.setNameFile(fileFb2);
            else fileFb2Obj = null;

        FileMobi fileMobiObj = new FileMobi();
        if (fileMobi != null)
            if (!fileMobi.equals("")) fileMobiObj.setNameFile(fileMobi);
            else fileMobiObj = null;

        updateCard(book, cycle, coverObj,fileEpubObj, fileFb2Obj, fileMobiObj);
    }


}
