package com.project.quizapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Quiz {

    //FIELDS
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    //MAPPING TO CATEGORY
    //MANY TO ONE
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name= "category_id")
    private Category category;

    //MAPPING TO QUESTIONS LIST
    //ONE TO MANY
    @OneToMany(mappedBy = "quiz")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Question> questionList;


}
