package com.project.quizapp.respository;

import com.project.quizapp.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long> {

    Quiz findByNameIgnoreCase(String name);


}
