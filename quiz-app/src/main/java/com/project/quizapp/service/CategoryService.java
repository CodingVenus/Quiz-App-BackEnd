package com.project.quizapp.service;

import com.project.quizapp.model.Category;
import com.project.quizapp.respository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CategoryService {

    CategoryRepository categoryRepository;

    //POST
    public Category createCategory(Category categoryObject) {

        Category category = categoryRepository.findByNameIgnoreCase(categoryObject.getCategoryName());

        if (category != null) {
            throw new InformationExistsException("Category with name " + category.getCategoryName() + " already exists");
        } else {
            return categoryRepository.save(categoryObject);
        }
    }




    //GET ALL




}
