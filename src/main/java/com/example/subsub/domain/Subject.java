package com.example.subsub.domain;

import jakarta.persistence.*;
import lombok.*;


@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@AllArgsConstructor
@Builder
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer subjectId;

    @Column(nullable = false)
    private String subjectName;

    @Column(nullable = false)
    private String professorName;

    @Column(nullable = false)
    private String date;

    @Column(nullable = false)
    private String classType;

    @Column(nullable = false)
    private String color;

    @ManyToOne
    private User user;
}