package com.project.quizapp.service;

import com.project.quizapp.exceptions.InformationExistsException;
import com.project.quizapp.exceptions.InformationNotFoundException;
import com.project.quizapp.model.Category;
import com.project.quizapp.respository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    //POST
    public Category createCategory(Category categoryObject) {

        Category category = categoryRepository.findByNameIgnoreCase(categoryObject.getName());

        if (category != null) {
            throw new InformationExistsException("Category with name " + category.getName() + " already exists");
        } else {
            return categoryRepository.save(categoryObject);
        }
    }


    //GET ALL
    public List<Category> getAllCategories() {
        List<Category> categoryList = categoryRepository.findAll();
        if (categoryList.isEmpty()) {
            throw new InformationNotFoundException("No categories found");
        } else {
            return categoryList;
        }
    }


}
