package com.project.quizapp.service;

import com.project.quizapp.respository.CategoryRepository;
import com.project.quizapp.respository.QuizRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class QuizService {

    private QuizRepository quizRepo;
    private CategoryRepository categoryRepo;



}
