package com.example.subsub.domain;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false,nullable = false)
    private int id;

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
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="user_userId")
    private User userId;
}
