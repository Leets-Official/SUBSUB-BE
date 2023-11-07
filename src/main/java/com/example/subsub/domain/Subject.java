package com.example.subsub.domain;

import com.example.subsub.dto.request.AddSubjectRequest;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@AllArgsConstructor
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

    @OneToMany(mappedBy = "subject")
    private List<Property> properties;

    @ManyToOne
    private User user;

    public static Subject from(AddSubjectRequest request){
        Subject subject = new Subject();
        subject.subjectName = request.getSubjectName();
        subject.professorName = request.getProfessorName();
        subject.date = request.getDate();
        subject.classType = request.getClassType();
        subject.color = request.getColor();
        return subject;
    }
}