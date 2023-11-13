package com.example.subsub.service;


import com.example.subsub.domain.Subject;
import com.example.subsub.domain.User;
import com.example.subsub.dto.request.AddSubjectRequest;
import com.example.subsub.repository.SubjectRepository;
import com.example.subsub.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SubjectService {

    private final SubjectRepository subjectRepository;
    private final UserRepository userRepository;

    public Subject writesave(AddSubjectRequest request, MultipartFile file, String userName) throws Exception {
            User user = userRepository.findByUserId(userName).get();

            String projectPath = System.getProperty("user.dir") + "/src/main/resources/static/file";

            String fileName = user + "_" + file.getOriginalFilename();
            File saveFile = new File(projectPath, fileName);
            file.transferTo(saveFile);

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
                    .fileName(fileName)
                    .filePath("/files/" + fileName)
                    .user(user)
                    .build();

            return subjectRepository.save(subject);
        }

    // 하나 조회
    public Subject findById(Integer id) {
        return subjectRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    // 모두 조회
    public List<Subject> getAllSubject(String userId) {
        User user = userRepository.findByUserId(userId).orElseThrow(IllegalArgumentException::new);
        return subjectRepository.findAllByUser(user);
    }

    public void subjectDelete(Integer id){
        subjectRepository.deleteById(id);
    }
}