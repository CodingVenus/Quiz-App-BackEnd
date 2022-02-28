package com.project.quizapp.service;

import com.project.quizapp.exceptions.InformationNotFoundException;
import com.project.quizapp.model.Category;
import com.project.quizapp.model.Quiz;
import com.project.quizapp.respository.CategoryRepository;
import com.project.quizapp.respository.QuizRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class QuizService {

    private QuizRepository quizRepo;
    private CategoryRepository categoryRepo;

    //GET METHODS

    //GET ALL QUIZZES
    public List<Quiz> getAllQuizzes() {
        List<Quiz> quizList = quizRepo.findAll();
        if (quizList.isEmpty()) {
            throw new InformationNotFoundException("No quizzes were found");
        } else {
            return quizList;
        }
    }

    //GET ALL QUIZZES BY CATEGORY
    public List<Quiz> getAllQuizzesByCategoryId(Long categoryId) {

        Optional<Category> category = categoryRepo.findById(categoryId);

//        if (category == null) {
        if (!category.isPresent()){
            throw new InformationNotFoundException("Category with ID " + categoryId +
                    " does not exist");
        }
        return category.get().getQuizList();
    }

}


