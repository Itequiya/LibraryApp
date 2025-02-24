package com.library.controllers;

import com.library.model.Library;
import com.library.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library")
public class LibraryController {

    @Autowired
    private LibraryService libraryService;

    @GetMapping("/")
    public List<Library> getAllLibraries() {
        return libraryService.getAllLibraries();
    }

    @GetMapping("/getLibraryByName")
    public Library getLibraryByName(@RequestParam("name") String name){
        return libraryService.getLibraryByName(name);
    }

    @PostMapping("/createLibrary")
    public Library createLibrary(@RequestBody Library library){
        return libraryService.createLibrary(library);
    }
    @DeleteMapping("/deleteLibrary")
    public void deleteLibrary(@RequestParam String name){
        libraryService.deleteLibrary(name);
    }



}


