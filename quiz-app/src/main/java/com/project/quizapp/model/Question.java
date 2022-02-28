package com.project.quizapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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
