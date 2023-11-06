package com.example.subsub.dto;

import com.example.subsub.domain.Subject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor //기본 생성자
@AllArgsConstructor //모든 필드를 매개변수로 하는 생성자
public class SubjectDTO {
    private Integer id;
    private String subjectName;
    private String professorName;

    private String day;
    private String classType;
    private String color;
    private Integer userId;


}
