package com.example.subsub.dto.response;

import com.example.subsub.domain.Subject;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class SubjectResponse {

    private final String subjectName;
    private final String professorName;
    private final boolean mon;
    private final boolean tue;
    private final boolean wed;
    private final boolean thurs;
    private final boolean fri;
    private final String classType;
    private final String color;
    private final String fileName;
    private final String filePath;
    private final List<PropertyResponse> properties;

    @Builder
    public SubjectResponse(Subject subject){
        subjectName = subject.getSubjectName();
        professorName = subject.getProfessorName();

        mon = subject.isMon();
        tue = subject.isTue();
        wed = subject.isWed();
        thurs = subject.isThurs();
        fri = subject.isFri();

        classType = subject.getClassType();
        color = subject.getColor();
        fileName = subject.getFileName();
        filePath = subject.getFilePath();
        properties = PropertyResponse.toList(subject.getProperties());
    }
}
