package com.library.service;
import com.library.model.Category;
import com.library.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service

public class CategoryService {
    @Autowired
    public CategoryRepository categoryRepository;

    public Category createCategory(Category category) {
            return categoryRepository.addCategory(category);
    }

    public String getCategoryNameById(Long id){
        return  categoryRepository.getCategoryNameById(id);
    }
}

