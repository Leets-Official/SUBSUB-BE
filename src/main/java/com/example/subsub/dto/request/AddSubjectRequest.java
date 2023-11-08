package com.example.subsub.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AddSubjectRequest {

    private String subjectName;
    private String professorName;
    private String date;
    private String classType;
    private String color;
}
