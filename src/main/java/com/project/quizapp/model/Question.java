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

    //FIELDS
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String question;
    @Transient
    @Setter(AccessLevel.NONE) //Override Lombok setter creation
    private String quizName;
    @Transient
    @Setter(AccessLevel.NONE)
    private String categoryName;

    //categoryName getters and setters
    //need this so i can get the category name from the quiz component in the frontend
    public String getCategoryName() {
        return this.quiz.getCategoryName();
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }


    //quizName Getters and Setters
    //need this so I can get the quiz name from the quiz component in the frontend
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
