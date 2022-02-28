package com.project.quizapp.service;

import com.project.quizapp.exceptions.InformationExistsException;
import com.project.quizapp.exceptions.InformationNotFoundException;
import com.project.quizapp.model.Answer;
import com.project.quizapp.model.Question;
import com.project.quizapp.respository.AnswerRepository;
import com.project.quizapp.respository.QuestionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AnswerService {

    private AnswerRepository answerRepo;
    private QuestionRepository questionRepo;


//POST METHODS

    //POST ANSWER BY QUESTION ID
    public Answer createAnswerByQuestionId(Long questionId, Answer answerObject) {

        Question question = questionRepo.findById(questionId).orElseThrow(()-> new InformationNotFoundException(
                "Question with ID " + questionId + " does not exist. Please try a different Question ID."));

        //it's fine if the same answer exists under a different question, so this validation will be for the specific question id
        Answer answer = answerRepo.findByQuestionIdAndAnswerIgnoreCase(questionId, answerObject.getAnswer());
        if (answer != null) {
            throw new InformationExistsException("The answer '" + answer.getAnswer() + "' already exists. Please create a different answer.");
        }
        answerObject.setQuestion(question);
        return answerRepo.save(answerObject);
    }


//GET METHODS

    //GET ALL ANSWERS - likely not necessary
    public List<Answer> getAllAnswers() {
        List<Answer> answerList = answerRepo.findAll();
        if (answerList.isEmpty()) {
            throw new InformationNotFoundException("No answers were found");
        } else {
            return answerList;
        }
    }

    //GET ALL ANSWERS BY QUESTION ID
    public List<Answer> getAllAnswerByQuestionId(Long questionId) {

        Optional<Question> question = questionRepo.findById(questionId);

        if (!question.isPresent()){
            throw new InformationNotFoundException("Question with ID " + questionId +
                    " does not exist");
        }
        return question.get().getAnswerList();
    }


}
