package com.example.demo.Controller;

import com.example.demo.Service.book.BookServise;
import com.example.demo.Service.book.FileEpubService;
import com.example.demo.Service.book.FileFb2Service;
import com.example.demo.Service.book.FileMobiService;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

@Controller
@RequestMapping("/resources")
public class ControllerFile {
    private final BookServise bookServise;
    private final FileEpubService fileEpubService;
    private final FileFb2Service fileFb2Service;
    private final FileMobiService fileMobiService;

    public ControllerFile(BookServise bookServise, FileEpubService fileEpubService, FileFb2Service fileFb2Service, FileMobiService fileMobiService) {
        this.bookServise = bookServise;
        this.fileEpubService = fileEpubService;
        this.fileFb2Service = fileFb2Service;
        this.fileMobiService = fileMobiService;
    }


    @GetMapping("/{dir}")
    public ResponseEntity<Resource> downloadFileEpub(@PathVariable String dir, @RequestParam Long id) throws FileNotFoundException {
        File file = new File("src/main/webapp/res/" + dir +"/" + fileEpubService.findByBook(bookServise.findById(id)).getNameFile());

        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

        String[] str = file.getName().split("#");

      return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + str[1])
                .body(resource);
    }

}
