package com.example.subsub.controller;

import com.example.subsub.domain.Subject;
import com.example.subsub.dto.SubjectDTO;
import com.example.subsub.dto.request.AddSubjectRequest;
import com.example.subsub.dto.response.SubjectResponse;
import com.example.subsub.service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subject")
@RequiredArgsConstructor
public class SubjectApiController {

    private final SubjectService subjectService;

    @PostMapping
    public ResponseEntity<SubjectDTO> save(@RequestBody AddSubjectRequest request){
        Subject savedSubject = subjectService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(SubjectDTO.toSubjectDto(savedSubject));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubjectResponse> findById(@PathVariable Integer id){
        Subject subject = subjectService.findById(id);
        return ResponseEntity.ok().body(new SubjectResponse(subject));
    }
}
