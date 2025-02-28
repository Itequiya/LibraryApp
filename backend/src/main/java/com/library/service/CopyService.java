package com.library.service;
import com.library.model.Book;
import com.library.model.Copy;
import com.library.repository.CopyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service

public class    CopyService {
@Autowired
    private CopyRepository copyRepository;
    public Integer Available(Long book_id ){ return copyRepository.AvailableCopies(book_id); }
    public Copy AddCopy (Copy copy){
        return copyRepository.addCopy(copy);
    }
}
