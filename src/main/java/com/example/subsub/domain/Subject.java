package com.example.subsub.domain;

import com.example.subsub.dto.request.AddSubjectRequest;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Builder
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

    @Column
    private String fileName;
    @Column
    private String filePath;

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
        subject.fileName = request.getFileName();
        subject.filePath = request.getFilePath();
        return subject;
    }
}