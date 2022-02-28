package com.project.quizapp.respository;

import com.project.quizapp.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Long> {

    Answer findByQuestionIdAndAnswerIgnoreCase(Long id, String answer);

}
