package com.example.subsub.dto;

import com.example.subsub.domain.Property;
import com.example.subsub.domain.Subject;
import lombok.Getter;

import java.util.List;

@Getter
public class SubjectDTO {

    private Integer subjectId;
    private String subjectName;
    private String professorName;
    private String date;
    private String classType;
    private String color;
    private String fileName;
    private String filePath;
    private List<Property> properties;

    public static SubjectDTO toSubjectDto(Subject subject){
        SubjectDTO subjectDTO = new SubjectDTO();
        subjectDTO.subjectId = subject.getSubjectId();
        subjectDTO.subjectName = subject.getSubjectName();
        subjectDTO.professorName = subject.getProfessorName();
        subjectDTO.date = subject.getDate();
        subjectDTO.classType = subject.getClassType();
        subjectDTO.color = subject.getColor();
        subjectDTO.fileName = subject.getFileName();
        subjectDTO.filePath = subject.getFilePath();
        subjectDTO.properties = subject.getProperties();
        return subjectDTO;
    }
}
