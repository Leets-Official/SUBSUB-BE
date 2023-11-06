package com.example.subsub.service;

import com.example.subsub.MapStruct.SubjectMapper;
import com.example.subsub.domain.Subject;
import com.example.subsub.dto.SubjectDTO;
import com.example.subsub.repository.SubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubjectService {
    private final SubjectRepository subjectRepository;
    private final SubjectMapper subjectMapper;

    public void save(SubjectDTO subjectDTO){
        Subject subjectEntity = subjectMapper.toEntity(subjectDTO);

        subjectRepository.save(subjectEntity);

    }
}
