package com.project.quizapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
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
    @Transient
    @Setter(AccessLevel.NONE) //Override Lombok setter creation
    private String categoryName;

    //quizName Getters and Setters
    public String getCategoryName() {
        return this.category.getName();
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

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
