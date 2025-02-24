package com.library.service;

import com.library.model.Library;
import com.library.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryService {

    @Autowired
    private LibraryRepository libraryRepository;

    public List<Library> getAllLibraries() {
        return libraryRepository.findAll();
    }

    public Library getLibraryByName(String name) {
        return libraryRepository.findByName(name);
    }

    public Library createLibrary(Library library) {
        return libraryRepository.save(library);
    }

    public void deleteLibrary(String name) {
        libraryRepository.deleteByName(name);
    }
}
