package com.example.subsub.service;

import com.example.subsub.domain.Property;
import com.example.subsub.domain.Subject;
import com.example.subsub.dto.request.AddPropertyRequest;
import com.example.subsub.repository.PropertyRepository;
import com.example.subsub.repository.SubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PropertyService {

    private final SubjectRepository subjectRepository;
    private final PropertyRepository propertyRepository;

    public Property save(AddPropertyRequest request) {
        Optional<Subject> subjectEntity = subjectRepository.findById(request.getSubjectId());
        if(subjectEntity.isPresent()){
            Subject subject = subjectEntity.get();

            Property property = Property.of(request, subject);
            return propertyRepository.save(property);
        }else {
            throw new IllegalArgumentException("과목 생성이 되지 않았습니다.");
        }
    }

    public void delete(Integer subjectId, Integer id) {
        propertyRepository.deleteBySubjectIdAndId(subjectId, id);
    }
}
