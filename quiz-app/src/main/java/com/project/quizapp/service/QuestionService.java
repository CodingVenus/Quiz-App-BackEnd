package com.project.quizapp.service;

import com.project.quizapp.exceptions.InformationExistsException;
import com.project.quizapp.exceptions.InformationNotFoundException;
import com.project.quizapp.model.Question;
import com.project.quizapp.model.Quiz;
import com.project.quizapp.respository.QuestionRepository;
import com.project.quizapp.respository.QuizRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class QuestionService {



    private QuestionRepository questionRepo;
    private QuizRepository quizRepo;


//POST METHODS

    //POST QUESTION BY QUIZ ID
    public Question createQuestionByQuizId(Long quizId, Question questionObject) {

        Quiz quiz = quizRepo.findById(quizId).orElseThrow(()-> new InformationNotFoundException(
                "Quiz with ID " + quizId + " does not exist. Please try a different Quiz ID."));

        //it's fine if question exists under different quiz, so this validation will be for the specific quiz id
        Question question = questionRepo.findByQuizIdAndQuestionIgnoreCase(quizId, questionObject.getQuestion());
        if (question != null) {
            throw new InformationExistsException("The question " + question.getQuestion() + " already exists. Please create a different Question");
        }
        questionObject.setQuiz(quiz);
        return questionRepo.save(questionObject);
    }


//GET METHODS

    //GET ALL QUESTIONS
    public List<Question> getAllQuestions() {
        List<Question> questionList = questionRepo.findAll();
        if (questionList.isEmpty()) {
            throw new InformationNotFoundException("No questions were found");
        } else {
            return questionList;
        }
    }

    //GET ALL QUESTIONS BY QUIZ ID
    public List<Question> getAllQuestionsByQuizId(Long quizId) {

        Optional<Quiz> quiz = quizRepo.findById(quizId);

        if (!quiz.isPresent()){
            throw new InformationNotFoundException("Quiz with ID " + quizId +
                    " does not exist");
        }
        return quiz.get().getQuestionList();
    }

}

