package com.example.subsub.dto.response;

import com.example.subsub.domain.Subject;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class SubjectResponse {

    private final String subjectName;
    private final String professorName;
    private final String date;
    private final String classType;
    private final String color;
    private final String fileName;
    private final String filePath;
    private final List<PropertyResponse> properties;

    @Builder
    public SubjectResponse(Subject subject){
        subjectName = subject.getSubjectName();
        professorName = subject.getProfessorName();
        date = subject.getDate();
        classType = subject.getClassType();
        color = subject.getColor();
        fileName = subject.getFileName();
        filePath = subject.getFilePath();
        properties = PropertyResponse.toList(subject.getProperties());
    }
}
