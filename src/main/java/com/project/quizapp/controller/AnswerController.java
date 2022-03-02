package com.project.quizapp.controller;


import com.project.quizapp.model.Answer;
import com.project.quizapp.service.AnswerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path ="/api")
public class AnswerController {
    //DEPENDENCIES
    AnswerService answerService;

    //GET MAPPING
    //GET Answers BY CATEGORY
    @GetMapping("question/{questionId}/answers")
    public List<Answer> getAllAnswersByQuestionId(@PathVariable(value="questionId") Long questionId){
        return answerService.getAllAnswerByQuestionId(questionId);
    }

    //GET ALL QUIZZES
    @GetMapping("answer/all")
    public List<Answer> getAllAnswer(){
        return answerService.getAllAnswers();
    }

    //POST MAPPING
    //POST BY CATEGORY ID
    @PostMapping("question/{questionId}/answer/new")
    public Answer createAnswerByQuestionId(@PathVariable(value="questionId") Long questionId, @RequestBody Answer answerObject){
        return answerService.createAnswerByQuestionId(questionId, answerObject);
    }


//DELETE MAPPING
    //DELETE BY ANSWER ID
    @DeleteMapping("answer/{answerId}")
    public String deleteAnswer(@PathVariable(value="answerId") Long answerId) {
        return answerService.deleteAnswer(answerId);
    }
}
