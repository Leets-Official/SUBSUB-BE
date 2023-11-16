package com.example.subsub.service;

import com.example.subsub.domain.Property;
import com.example.subsub.domain.Subject;
import com.example.subsub.domain.User;
import com.example.subsub.dto.request.AddPropertyRequest;
import com.example.subsub.dto.request.UpdatePropertyRequest;
import com.example.subsub.repository.PropertyRepository;
import com.example.subsub.repository.SubjectRepository;
import com.example.subsub.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PropertyService {

    private final UserRepository userRepository;
    private final SubjectRepository subjectRepository;
    private final PropertyRepository propertyRepository;

    public Property save(AddPropertyRequest request, String userName) {
        Subject subjectEntity = subjectRepository.findById(request.getSubjectId()).orElseThrow(IllegalArgumentException::new);
        User user = userRepository.findByUserId(userName).orElseThrow(IllegalArgumentException::new);
        Property property = Property.of(request, subjectEntity, user);
        return propertyRepository.save(property);
    }

    @Transactional
    public void delete(Integer propertyId) {
        propertyRepository.deleteById(propertyId);
    }

    public List<Property> findBySubjectId(Integer subjectId) {
        return propertyRepository.findBySubjectSubjectIdOrderByIsCompletedAscExpiredAtAsc(subjectId);
    }

    @Transactional
    public Property update(Integer id, UpdatePropertyRequest request) {
        Property savedProperty = propertyRepository.findById(id).orElseThrow(IllegalArgumentException::new);

        savedProperty.update(request);
        return savedProperty;
    }

    @Transactional
    public List<Property> getTop5PropertiesOrderedByExpiredAt(String userId){
        User user = userRepository.findByUserId(userId).orElseThrow(IllegalArgumentException::new);
        return propertyRepository.findTop5ByUserOrderByExpiredAtAsc(user);
    }
}
