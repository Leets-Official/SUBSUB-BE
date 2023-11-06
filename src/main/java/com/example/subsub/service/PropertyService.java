package com.example.subsub.service;

import com.example.subsub.domain.Property;
import com.example.subsub.domain.Subject;
import com.example.subsub.dto.PropertyDTO;
import com.example.subsub.dto.request.AddPropertyRequest;
import com.example.subsub.repository.PropertyRepository;
import com.example.subsub.repository.SubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PropertyService {

    private final SubjectRepository subjectRepository;
    private final PropertyRepository propertyRepository;

    public Property save(AddPropertyRequest request) {
        Subject subjectEntity = subjectRepository.findById(request.getSubjectId()).orElseThrow(IllegalArgumentException::new);
        Property property = Property.of(request, subjectEntity);
        return propertyRepository.save(property);
    }

    public void delete(Integer propertyId) {
        propertyRepository.deleteById(propertyId);
    }

    public List<Property> findAll() {
        return propertyRepository.findAll();
    }

    public Property findById(Integer id) {
        return propertyRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }
}
