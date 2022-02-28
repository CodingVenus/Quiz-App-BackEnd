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

    private final CategoryRepository categoryRepo;

    //POST
    public Category createCategory(Category categoryObject) {

        Category category = categoryRepo.findByNameIgnoreCase(categoryObject.getName());

        if (category != null) {
            throw new InformationExistsException("Category with name " + category.getName() + " already exists");
        } else {
            return categoryRepo.save(categoryObject);
        }
    }


    //GET ALL
    public List<Category> getAllCategories() {
        List<Category> categoryList = categoryRepo.findAll();
        if (categoryList.isEmpty()) {
            throw new InformationNotFoundException("No categories were found");
        } else {
            return categoryList;
        }
    }


    //GET BY ID
    public Category getCategoryById(Long categoryId) {

        Category category = categoryRepo.findById(categoryId).orElseThrow(() -> new InformationNotFoundException(
                "Category with ID " + categoryId + " does not exist. Please try a different Category ID."));
        return category;
    }

//DELETE METHOD
    //DELETE BY ID
    public String deleteCategory(Long categoryId) {

        Category category = categoryRepo.findById(categoryId).orElseThrow(() -> new InformationNotFoundException(
                "Category with ID " + categoryId + " does not exist. Please try a different Category ID."));

        categoryRepo.deleteById(categoryId);
        return "Category: '" + category.getName() + "' Id: " + categoryId + " has been successfully deleted.";
    }

}
