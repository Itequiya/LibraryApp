package com.library.service;
import com.library.model.Copy;
import com.library.repository.CopyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class    CopyService {
@Autowired
    private CopyRepository copyRepository;
    public Integer getAvailable(Long book_id ){ return copyRepository.availableCopies(book_id); }
    public Copy addCopy (Copy copy){
        return copyRepository.addCopy(copy);
    }
    public void changeStatus (Long copy_id, Long status_copy_id ){ copyRepository.changeStatus(copy_id, status_copy_id);}
}
