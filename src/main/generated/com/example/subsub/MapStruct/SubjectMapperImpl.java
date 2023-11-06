package com.example.subsub.MapStruct;

import com.example.subsub.domain.Subject;
import com.example.subsub.domain.Subject.SubjectBuilder;
import com.example.subsub.domain.User;
import com.example.subsub.domain.User.UserBuilder;
import com.example.subsub.dto.SubjectDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-06T05:03:07+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.9 (Amazon.com Inc.)"
)
@Component
public class SubjectMapperImpl implements SubjectMapper {

    @Override
    public SubjectDTO toDto(Subject entity) {
        if ( entity == null ) {
            return null;
        }

        SubjectDTO subjectDTO = new SubjectDTO();

        String userId = entityUserIdUserId( entity );
        if ( userId != null ) {
            subjectDTO.setUserId( Integer.parseInt( userId ) );
        }
        subjectDTO.setId( entity.getId() );
        subjectDTO.setSubjectName( entity.getSubjectName() );
        subjectDTO.setProfessorName( entity.getProfessorName() );
        subjectDTO.setDay( entity.getDay() );
        subjectDTO.setClassType( entity.getClassType() );
        subjectDTO.setColor( entity.getColor() );

        return subjectDTO;
    }

    @Override
    public Subject toEntity(SubjectDTO dto) {
        if ( dto == null ) {
            return null;
        }

        SubjectBuilder subject = Subject.builder();

        subject.userId( subjectDTOToUser( dto ) );
        subject.subjectName( dto.getSubjectName() );
        subject.professorName( dto.getProfessorName() );
        subject.day( dto.getDay() );
        subject.classType( dto.getClassType() );
        subject.color( dto.getColor() );

        return subject.build();
    }

    private String entityUserIdUserId(Subject subject) {
        if ( subject == null ) {
            return null;
        }
        User userId = subject.getUserId();
        if ( userId == null ) {
            return null;
        }
        String userId1 = userId.getUserId();
        if ( userId1 == null ) {
            return null;
        }
        return userId1;
    }

    protected User subjectDTOToUser(SubjectDTO subjectDTO) {
        if ( subjectDTO == null ) {
            return null;
        }

        UserBuilder user = User.builder();

        if ( subjectDTO.getUserId() != null ) {
            user.userId( String.valueOf( subjectDTO.getUserId() ) );
        }

        return user.build();
    }
}
