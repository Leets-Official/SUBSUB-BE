package com.example.subsub.domain;

import jakarta.persistence.*;
import lombok.*;


@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subject_id", nullable = false)
    private Integer id;

    @Column(nullable = false)
    private String subjectName;

    @Column(nullable = false)
    private String professorName;

    @Column(nullable = false)
    private String day;

    @Column(nullable = false)
    private String classType;

    @Column(nullable = false)
    private String color;

    @Column(nullable = false)
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User userId;

    @Builder
    private Subject(String subjectName, String professorName, String day, String classType, String color, User userId) {
        this.subjectName = subjectName;
        this.professorName = professorName;
        this.day = day;
        this.classType = classType;
        this.color = color;
        this.userId = userId;
    }
}