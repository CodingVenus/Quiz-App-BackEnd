package com.project.quizapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String question;
    @Transient
    @Setter(AccessLevel.NONE) //Override Lombok setter creation
    private String quizName;

    //quizName Getters and Setters
    public String getQuizName() {
        return this.quiz.getName();
    }

    public void setQuizName(String quizName) {
        this.quizName = quizName;
    }

    //MAPPING TO ANSWER LIST
    //ONE TO MANY
    @OneToMany(mappedBy = "question")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Answer> answerList;

    //MAPPING TO QUIZ
    //MANY TO ONE
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name= "quiz_id")
    private Quiz quiz;

}
