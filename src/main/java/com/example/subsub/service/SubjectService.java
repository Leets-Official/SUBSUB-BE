package com.example.subsub.service;


import com.example.subsub.domain.Subject;
import com.example.subsub.domain.User;
import com.example.subsub.dto.request.AddSubjectRequest;
import com.example.subsub.repository.SubjectRepository;
import com.example.subsub.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubjectService {

    private final SubjectRepository subjectRepository;
    private final UserRepository userRepository;

    public Subject writesave(AddSubjectRequest request, String userName) throws Exception {
            User user = userRepository.findByUserId(userName).get();

            Subject subject = Subject.builder()
                    .subjectName(request.getSubjectName())
                    .professorName(request.getProfessorName())
                    .mon(request.isMon())
                    .tue(request.isTue())
                    .wed(request.isWed())
                    .thu(request.isThu())
                    .fri(request.isFri())
                    .classType(request.getClassType())
                    .color(request.getColor())
                    .user(user)
                    .build();

            return subjectRepository.save(subject);
        }


    // 하나 조회
    public Subject findById(Integer id) {
        return subjectRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    // 모두 조회
    public List<Subject> getAllSubject(String userid) {
        User user = userRepository.findByUserId(userid).orElseThrow(IllegalArgumentException::new);
        return subjectRepository.findAllByUser(user);
    }

    public void subjectDelete(Integer id){
        subjectRepository.deleteById(id);
    }

}