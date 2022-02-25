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

        Category category = categoryRepository.findById()
    }




    //GET ALL




}
