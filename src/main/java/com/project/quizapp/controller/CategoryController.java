package com.project.quizapp.controller;

import com.project.quizapp.model.Category;
import com.project.quizapp.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path ="/api/category")
public class CategoryController {

    private final CategoryService categoryService;


//POST MAPPING
    @PostMapping(path = "/new")
    public Category createCategory(@RequestBody Category categoryObject) {
        return categoryService.createCategory(categoryObject);
    }

//GET MAPPING
    @GetMapping(path = "/all")
    public List<Category> getAllCategories(){
        return categoryService.getAllCategories();
    }

    @GetMapping("{categoryId}")
    public Category getCategoryById(@PathVariable(value="categoryId") Long categoryId) {
        return categoryService.getCategoryById(categoryId);
    }

//DELETE MAPPING
    //DELETE BY CATEGORY ID
    @DeleteMapping("{categoryId}")
    public String deleteCategory(@PathVariable(value="categoryId") Long categoryId) {
        return categoryService.deleteCategory(categoryId);
    }
}
