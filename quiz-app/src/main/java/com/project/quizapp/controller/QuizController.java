package com.project.quizapp.controller;


import com.project.quizapp.model.Quiz;
import com.project.quizapp.service.QuizService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path ="/api")
public class QuizController {

//DEPENDENCIES
QuizService quizService;



//GET MAPPING
    //GET QUIZZES BY CATEGORY
    @GetMapping("category/{categoryId}/quiz/all")
    public List<Quiz> getAllQuizzesByCategoryId(@PathVariable(value="categoryId") Long categoryId){
        return quizService.getAllQuizzesByCategoryId(categoryId);
    }

    //GET ALL QUIZZES
    @GetMapping("quiz/all")
    public List<Quiz> getAllQuizzes(){
        return quizService.getAllQuizzes();
    }

//POST MAPPING
    //POST BY CATEGORY ID
    @PostMapping("category/{categoryId}/quiz/new")
    public Quiz createQuizByCategoryId(@PathVariable(value="categoryId") Long categoryId, @RequestBody Quiz quizObject){
        return quizService.createQuizByCategoryId(categoryId, quizObject);
    }



}
