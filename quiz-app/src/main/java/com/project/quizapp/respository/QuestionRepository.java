package com.project.quizapp.respository;

import com.project.quizapp.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

    Question findByQuizIdAndQuestionIgnoreCase(Long id, String question);

}
