package com.project.quizapp.controller;


import com.project.quizapp.model.Question;
import com.project.quizapp.service.QuestionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path ="/api")
public class QuestionController {
    //DEPENDENCIES
    QuestionService questionService;



    //GET MAPPING
    //GET QUIZZES BY CATEGORY
    @GetMapping("quiz/{quizId}/questions")
    public List<Question> getAllQuestionsByQuizId(@PathVariable(value="quizId") Long quizId){
        return questionService.getAllQuestionsByQuizId(quizId);
    }

    //GET ALL QUIZZES
    @GetMapping("question/all")
    public List<Question> getAllQuestions(){
        return questionService.getAllQuestions();
    }

    //POST MAPPING
    //POST BY CATEGORY ID
    @PostMapping("quiz/{quizId}/question/new")
    public Question createQuestionByQuizId(@PathVariable(value="quizId") Long quizId, @RequestBody Question questionObject){
        return questionService.createQuestionByQuizId(quizId, questionObject);
    }

}
