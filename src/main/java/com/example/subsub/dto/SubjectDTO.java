package com.example.subsub.dto;

import com.example.subsub.domain.Property;
import com.example.subsub.domain.Subject;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Data
@NoArgsConstructor
public class SubjectDTO {

    @NotNull(message = "subjectId cannot be null")
    @Schema(description = "과목 고유번호 자동 부여")
    private Integer subjectId;

    @Schema(description = "과목 이름", nullable = false, example = "데이터베이스")
    private String subjectName;

    @Schema(description = "교수님 성함", nullable = false, example = "최아영교수님")
    private String professorName;

    private boolean mon;
    private boolean tue;
    private boolean wed;
    private boolean thurs;
    private boolean fri;

    @Schema(description = "수업 종류", nullable = false, example = "전공필수")
    private String classType;

    @Schema(description = "과목 고유 색상", nullable = false, example = "#FFFFFF")
    private String color;

    private List<Property> properties;

    public static SubjectDTO toSubjectDto(Subject subject){
        SubjectDTO subjectDTO = new SubjectDTO();
        subjectDTO.subjectName = subject.getSubjectName();
        subjectDTO.professorName = subject.getProfessorName();
        subjectDTO.classType = subject.getClassType();
        subjectDTO.color = subject.getColor();
        subjectDTO.mon = subject.isMon();
        subjectDTO.tue = subject.isTue();
        subjectDTO.wed = subject.isWed();
        subjectDTO.fri = subject.isFri();


        return subjectDTO;
    }
}
