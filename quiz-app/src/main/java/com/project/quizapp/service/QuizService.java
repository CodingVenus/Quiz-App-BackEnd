package com.project.quizapp.service;

import com.project.quizapp.exceptions.InformationExistsException;
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


//POST METHODS

//    GETQUIZ() METHOD USED IN POST METHOD TO STOP DUPLICATE CODE
    public Quiz getQuiz(Quiz quizObject, Category category) {
        Quiz quiz = quizRepo.findByNameIgnoreCase(quizObject.getQuizName());
        if (quiz != null) {
            throw new InformationExistsException("Quiz with the name " + quiz.getQuizName() + " already exists.");
        }
        quizObject.setCategory(category);
        return quizRepo.save(quizObject);
    }





    //POST QUIZ BY CATEGORY ID
    public Quiz createQuizByCategoryId(Long categoryId, Quiz quizObject) {


        //Find by ID throws back optional, and you can't set the regular category,
        // so to get around this I will use .or else throw method which returns regular category
        Category category = categoryRepo.findById(categoryId).orElseThrow(()-> new InformationNotFoundException(
                "Category with ID " + categoryId + " does not exist. Please try a different Category ID."));
//        if (!category.isPresent()) {
//            throw new InformationNotFoundException(
//                    "Category with ID " + categoryId + " does not exist. Please try a different Category ID.");
//        }
//        Quiz quiz = quizRepo.findByNameIgnoreCase(quizObject.getQuizName());
//        if (quiz != null) {
//            throw new InformationExistsException("Quiz with the name " + quiz.getQuizName() + " already exists.");
//        }
//        quizObject.setCategory(category);
//        return quizRepo.save(quizObject);

        return getQuiz(quizObject, category);
    }





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


