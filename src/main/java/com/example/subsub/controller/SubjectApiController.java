package com.example.subsub.controller;

import com.example.subsub.dto.SubjectDTO;
import com.example.subsub.service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequiredArgsConstructor
@RequestMapping("/subject")
public class SubjectApiController {
    private final SubjectService subjectService;

    @PostMapping("/save")
    public String save(@ModelAttribute SubjectDTO subjectDTO) {
        System.out.println("subjectDTO = " + subjectDTO); //확인용
        subjectService.save(subjectDTO);
        return null;
    }

}
