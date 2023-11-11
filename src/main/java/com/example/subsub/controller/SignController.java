package com.example.subsub.controller;


import com.example.subsub.dto.response.RegisterResponse;
import com.example.subsub.dto.request.SignRequest;
import com.example.subsub.dto.response.SignResponse;
import com.example.subsub.repository.UserRepository;
import com.example.subsub.service.SignService;
import com.example.subsub.service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SignController {

    private final UserRepository userRepository;
    private final SignService userService;
    private final SubjectService subjectService;

    @PostMapping(value = "/login")
    public ResponseEntity<SignResponse> signin(@RequestBody SignRequest request) throws Exception {
        return new ResponseEntity<>(userService.login(request), HttpStatus.OK);
    }

    @PostMapping(value = "/register")
    public ResponseEntity<RegisterResponse> signup(@RequestBody SignRequest request) throws Exception {
        return new ResponseEntity<>(userService.register(request), HttpStatus.OK);
    }

    @GetMapping("/user/get")
    public ResponseEntity<SignResponse> getUser(@RequestParam String id) throws Exception {
        return new ResponseEntity<>( userService.getUser(id), HttpStatus.OK);
    }

    @GetMapping("/admin/get")
    public ResponseEntity<SignResponse> getUserForAdmin(@RequestParam String id) throws Exception {
        return new ResponseEntity<>( userService.getUser(id), HttpStatus.OK);
    }

}