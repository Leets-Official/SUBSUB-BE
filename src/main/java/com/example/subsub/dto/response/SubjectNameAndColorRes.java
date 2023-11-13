package com.example.subsub.dto.response;

import com.example.subsub.domain.Subject;
import lombok.Getter;

@Getter
public class SubjectNameAndColorRes {

    private final String subjectName;
    private final String color;

    public SubjectNameAndColorRes(Subject subject){
        this.subjectName = subject.getSubjectName();
        this.color = subject.getColor();
    }
}
