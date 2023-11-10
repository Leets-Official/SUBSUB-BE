package com.example.subsub.service;

import com.example.subsub.domain.Property;
import com.example.subsub.domain.Subject;
import com.example.subsub.domain.User;
import com.example.subsub.dto.SubjectDTO;
import com.example.subsub.dto.request.AddSubjectRequest;
import com.example.subsub.repository.SubjectRepository;
import com.example.subsub.repository.UserRepository;
import com.example.subsub.security.JwtProvider;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SubjectService {

    private final SubjectRepository subjectRepository;
    private final UserRepository userRepository;


    public Subject save(AddSubjectRequest request, String userName) {
        User user = userRepository.findByUserId(userName).get();
        Subject subject = Subject.builder()
                .subjectName(request.getSubjectName())
                .professorName(request.getProfessorName())
                .date(request.getDate())
                .classType(request.getClassType())
                .color(request.getColor())
                .fileName(request.getFileName())
                .filePath(request.getFilePath())
                .properties(new ArrayList<Property>())
                .user(user)
                .build();
        return subjectRepository.save(subject);
    }

    public Subject findById(Integer id) {
        return subjectRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    public List<Subject> getAllSubject(String userid) {
        User user = userRepository.findByUserId(userid).get();

        return subjectRepository.findAllByUser(user);
    }

    //신규 코드
    public Subject write(SubjectDTO subjectDTO, MultipartFile file, User user) throws Exception {
        String projectPath = System.getProperty("user.dir") + "/src/main/resources/static/file";

        UUID uuid = UUID.randomUUID();

        String originalFileName = file.getOriginalFilename();
        String fileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
        String fileName = uuid + fileExtension;

        File saveFile = new File(projectPath, fileName);
        file.transferTo(saveFile);

        Subject subject = Subject.builder().date(subjectDTO.getDate())
                /*.user(user)
                .subjectId(subjectDTO.getSubjectId())
                .subjectName(subjectDTO.getSubjectName())
                .professorName(subjectDTO.getProfessorName())
                .date(subjectDTO.getDate())
                .classType(subjectDTO.getClassType())
                .color(subjectDTO.getColor())
                .properties(subjectDTO.getProperties())
                .build();*/
                .date(subjectDTO.getDate())
                .user(user)
                .subjectId(subjectDTO.getSubjectId())
                .subjectName(subjectDTO.getSubjectName())
                .professorName(subjectDTO.getProfessorName())
                .date(subjectDTO.getDate())
                .classType(subjectDTO.getClassType())
                .color(subjectDTO.getColor())
                .properties(subjectDTO.getProperties())
                .fileName(fileName)
                .filePath("/file/" + fileName)
                .build();
        return subjectRepository.save(subject);
    }

/*
        String fileName = uuid + "_" + file.getOriginalFilename();
        File saveFile = new File(projectPath, fileName);
        file.transferTo(saveFile);

        subject.getFilePath();
        Subject.from("/files/" + fileName);

        return subjectRepository.save(subject); //3.반환값을 저장한다.*/


    public Optional<Subject> postView(Integer id){return subjectRepository.findById(id);
    }

    public void subjectDelete(Integer id){
        subjectRepository.deleteById(id);
    }

}