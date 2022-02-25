package com.project.quizapp.controller;

import com.project.quizapp.model.Category;
import com.project.quizapp.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path ="/api/category")
public class CategoryController {

    private final CategoryService categoryService;


//POST MAPPING
    public Category createCategory(@RequestBody Category categoryObject) {
        return categoryService.createCategory(categoryObject);
    }

//GET MAPPING
    @GetMapping()
    public List<Category> getAllCategories(){
        return categoryService.getAllCategories();
    }


}
