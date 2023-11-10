package com.example.subsub.service;

import com.example.subsub.domain.Subject;
import com.example.subsub.domain.User;
import com.example.subsub.dto.SubjectDTO;
import com.example.subsub.dto.request.AddSubjectRequest;
import com.example.subsub.repository.SubjectRepository;
import com.example.subsub.repository.UserRepository;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SubjectService {

    private final SubjectRepository subjectRepository;
    private final UserRepository userRepository;

    public Subject save(AddSubjectRequest request) {
        return subjectRepository.save(Subject.from(request));
    }

    public Subject findById(Integer id) {
        return subjectRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    //신규 코드
    public Subject write(SubjectDTO subjectDTO, MultipartFile file, User user) throws Exception {

        String projectPath = System.getProperty("user.dir") + "/src/main/resources/static/file";

        UUID uuid = UUID.randomUUID();

        String fileName = uuid + "_" + file.getOriginalFilename();
        File saveFile = new File(projectPath, fileName);
        file.transferTo(saveFile);

        subjectDTO.setFileName(fileName);
        subjectDTO.setFilePath("//files//" + fileName);


        Subject subject = Subject.builder()//.date(subjectDTO.getDate())
                .user(user)
                .subjectId(subjectDTO.getSubjectId())
                .subjectName(subjectDTO.getSubjectName())
                .professorName(subjectDTO.getProfessorName())
                //.date(subjectDTO.getDate())
                .mon(subjectDTO.isMon())
                .tue(subjectDTO.isTue())
                .wed(subjectDTO.isWed())
                .fri(subjectDTO.isFri())
                .classType(subjectDTO.getClassType())
                .color(subjectDTO.getColor())
                .fileName(subjectDTO.getFileName())
                .filePath(subjectDTO.getFilePath())

                .properties(subjectDTO.getProperties())
                .build();




        return subjectRepository.save(subject);
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }
    public Optional<Subject> postView(Integer id){return subjectRepository.findById(id);
    }

    public void subjectDelete(Integer id){

        subjectRepository.deleteById(id);
    }

}