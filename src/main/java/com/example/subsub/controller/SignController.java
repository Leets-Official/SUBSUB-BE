package com.example.subsub.controller;

import com.example.subsub.dto.request.SignRequest;
import com.example.subsub.dto.response.RegisterResponse;
import com.example.subsub.dto.response.SignResponse;
import com.example.subsub.service.SignService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class SignController {

    private final SignService userService;

    @PostMapping(value = "/login")
    public ResponseEntity<SignResponse> signIn(@RequestBody SignRequest request) throws Exception {
        return userService.login(request);
    }

    @PostMapping(value = "/register")
    public ResponseEntity<RegisterResponse> signUp(@RequestBody SignRequest request) throws Exception {
        return userService.register(request);
    }

    @GetMapping("/user/get")
    public ResponseEntity<SignResponse> getUser(@RequestParam String id) throws Exception {
        return userService.getUser(id);
    }

    @GetMapping("/admin/get")
    public ResponseEntity<SignResponse> getUserForAdmin(@RequestParam String id) throws Exception {
        return userService.getUser(id);
    }
}