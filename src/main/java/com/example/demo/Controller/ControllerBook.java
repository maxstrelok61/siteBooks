package com.example.demo.Controller;

import com.example.demo.Dto.dtoUser;
import com.example.demo.Model.BookView;
import com.example.demo.Model.ListBookView;
import com.example.demo.Model.Status;
import com.example.demo.Model.book.*;
import com.example.demo.Model.user.Role;
import com.example.demo.Model.user.StatusRole;
import com.example.demo.Model.user.User;
import com.example.demo.Service.MainBookService;
import com.example.demo.Service.book.*;
import com.example.demo.repository.user.RoleRepository;
import com.example.demo.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;


@org.springframework.stereotype.Controller
public class ControllerBook {

    private final GenreService genreService;
    private final TagService tagService;
    private final AuthorService authorService;
    private final BookServise bookServise;
    private final CycleService cycleService;
    private final CoverService coverService;
    private final FileEpubService fileEpubService;
    private final FileFb2Service fileFb2Service;
    private final FileMobiService fileMobiService;

    private final MainBookService mainBookService;
    private final ResourceLoader resourceLoader;
    private UserService serviceUser;
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;

    ListBookView listBookView = new ListBookView();


    @Autowired
    public ControllerBook(GenreService genreService, TagService tagService, AuthorService authorService, BookServise bookServise, CycleService cycleService, CoverService coverService, FileEpubService fileEpubService, FileFb2Service fileFb2Service, FileMobiService fileMobiService, MainBookService mainBookService, ResourceLoader resourceLoader, UserService serviceUser,
                          RoleRepository roleRepository,
                          UserRepository userRepository){
        this.genreService = genreService;
        this.tagService = tagService;
        this.authorService = authorService;
        this.bookServise = bookServise;
        this.cycleService = cycleService;
        this.coverService = coverService;
        this.fileEpubService = fileEpubService;
        this.fileFb2Service = fileFb2Service;
        this.fileMobiService = fileMobiService;

        this.mainBookService = mainBookService;
        this.resourceLoader = resourceLoader;
        this.serviceUser = serviceUser;

        //this.authenticationManager = authenticationManager;

        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/main")
    public String main(@RequestParam(required = false) String tagsListBook,
                       @RequestParam(required = false) String genresListBook,
                       @RequestParam(required = false) String bookName,
                       Model model) {

        List<Tag> listTags = null;
        if (tagsListBook != null) listTags = tagService.strToTags(strToList(tagsListBook));
        List<Genre> listGenres = null;
        if (genresListBook != null) listGenres = genreService.strToGenres(strToList(genresListBook));

//        System.out.println(bookName + "|" + listGenres + "|" + listTags);

        listBookView.clear();
        listBookView.addListBook(bookServise.findAllByFiltr(bookName,listGenres,listTags));
        listBookView.addListCover(coverService.findAllByBooks(listBookView.getListBooks()));

        List<Genre> genres = genreService.findAll();
        List<Tag> tags = tagService.findAll();


        model.addAttribute("listBooks" , listBookView);
        model.addAttribute("genres" , genres);
        model.addAttribute("tags" , tags);
        model.addAttribute("user", new dtoUser(SecurityContextHolder.getContext().getAuthentication(), serviceUser));

        model.addAttribute("selectFiltrTags", listTags);
        model.addAttribute("selectFiltrGenres", listGenres);
        model.addAttribute("selectFiltrBookName", bookName);

        return "main";
    }

    @PostMapping(value = "/edit_elem")
    public String addBookElem(@RequestParam String inputNameBook, @RequestParam String authorsListBook,
                          @RequestParam String genresListBook, @RequestParam String tagsListBook,
                          @RequestParam String descriptionBook, @RequestParam String authorsAllList,
                          @RequestParam String genresAllList, @RequestParam String tagsAllList,
                          @RequestParam String bookId,
                          @RequestParam("fileCoverBook") MultipartFile fileCover, @RequestParam("fileEpubBook") MultipartFile fileEpub,
                          @RequestParam("fileFb2Book") MultipartFile fileFb2, @RequestParam("fileMobiBook") MultipartFile fileMobi,
                          @RequestParam(defaultValue = "false") boolean checkDelete, @RequestParam(defaultValue = "false") boolean checkPublick,
                          @RequestParam(defaultValue = "false") boolean checkEnd,
                          @RequestParam String cycleBook,
                          @RequestParam String _csrf) {

        //--------------------Получение массивов со страницы
        authorService.strToAuthor(strToList(authorsAllList));
        genreService.strToGenres(strToList(genresAllList));
        tagService.strToTags(strToList(tagsAllList));

        List<Author> listAuthors = authorService.strToAuthor(strToList(authorsListBook));
        List<Tag> listTags = tagService.strToTags(strToList(tagsListBook));
        List<Genre> listGenres = genreService.strToGenres(strToList(genresListBook));
        //--------------------Проверка Check-----------------------
        StatusBook statusBook = StatusBook.ENDED;
        Status status = Status.ACTIVE;
        VisebleBook visebleBook = VisebleBook.PRIVATE;


        if (checkDelete) status = Status.DELETED;
        else status = Status.ACTIVE;

        if (checkPublick) visebleBook = VisebleBook.PUBLIC;
        else visebleBook = VisebleBook.PRIVATE;

        if (checkEnd) statusBook = StatusBook.ENDED;
        else statusBook = StatusBook.PROCESS;

        //--------------------Создание новой книги------------------
        Book newBook ;

        //-------------------
        if (Long.parseLong(bookId) > 0) {
            newBook = bookServise.findById(Long.parseLong(bookId));
            if (newBook == null) newBook = new Book();
            newBook.setAtributeBook(inputNameBook,descriptionBook,listAuthors,listGenres,listTags, status, statusBook, visebleBook);
        }else{
            newBook = new Book(inputNameBook,descriptionBook,listAuthors,listGenres,listTags, status, statusBook, visebleBook);
        }

        if (!cycleBook.equals("")) {
            Cycle c = cycleService.fyndCycleByName(cycleBook);
            c.addBook(newBook);
            cycleService.save(c);
        }
        //-------------------Добавление книг и обложки------------------------

        mainBookService.updateCard(newBook, null, checkFile(fileCover, "src/main/webapp/res/img/"),
                checkFile(fileEpub, "src/main/webapp/res/epub/"),
                checkFile(fileEpub, "src/main/webapp/res/fb2/"),
                checkFile(fileEpub, "src/main/webapp/res/mobi/"));
        return "redirect:/main";
    }



    public BookView findBookById(Long id){
        BookView bv;

        if (id == 0){
            bv = new BookView(new Book());
            bv.getBook().setId(id);
        }else{
            bv =  new BookView(bookServise.findById(id));
            bv.setCover(coverService.findByBook(bv.getBook()));
            bv.setFileFb2(fileFb2Service.findByBook(bv.getBook()));
            bv.setFileMobi(fileMobiService.findByBook(bv.getBook()));
            bv.setFileEpub(fileEpubService.findByBook(bv.getBook()));
            bv.setCycle(cycleService.findByBook(bv.getBook()));
        }

        return bv;
    }

    @GetMapping("/book")
    public String book(@RequestParam("id") Long id, Model model) {

        BookView bv = findBookById(id);

        model.addAttribute("book", bv);
        model.addAttribute("user", new dtoUser(SecurityContextHolder.getContext().getAuthentication(), serviceUser));
        return "book";
    }

    @GetMapping("/addbook")
    public String addBook(@RequestParam("id") Long id, Model model){
        List<Tag> lTag = tagService.findAll();
        List<String> nameTags = new ArrayList<>();

        for (int i = 0; i < lTag.size(); i++) {
            nameTags.add(lTag.get(i).getName());
        }

        BookView bv = findBookById(id);

        model.addAttribute("listGenre",  genreService.findAll());
        model.addAttribute("listTag", tagService.findAll());
        model.addAttribute("bookNew", bv);
        model.addAttribute("listCycle", cycleService.findAll());
        model.addAttribute("listAuthor", authorService.findAll());
        model.addAttribute("user", new dtoUser(SecurityContextHolder.getContext().getAuthentication(), serviceUser));
        return "addBook";
    }




    private String checkFile(MultipartFile file, String dir){
        //System.out.println("file-" + file.getOriginalFilename() + " dir-" + dir);
        if (!file.getOriginalFilename().equals("")) return  loadFile(file, dir);
        return "";
    }
    //-----------Заись переданного файла-----------------------
    private String loadFile(MultipartFile file, String dir){
        String nameFile = System.currentTimeMillis() + "_" + file.getOriginalFilename();
        File fileOut = new File( dir + nameFile);

        try (InputStream is = file.getInputStream()) {
            Files.copy(is, fileOut.toPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return nameFile;
    }
    //-----------Перевод переданоой строки-массива в массив
    private List<String> strToList(String str){
        String[] arrStr = str.split(",");
        List<String> list = new ArrayList<>();

        for (int i = 0; i < arrStr.length; i++) {
            list.add(arrStr[i]);
        }
        return list;
    }

}
