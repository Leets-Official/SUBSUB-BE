package com.example.subsub.service;

import com.example.subsub.domain.Authority;
import com.example.subsub.domain.User;
import com.example.subsub.dto.SignRequest;
import com.example.subsub.dto.SignResponse;
import com.example.subsub.repository.UserRepository;
import com.example.subsub.security.JwtProvider;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@Transactional
@RequiredArgsConstructor
public class SignService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;

    public SignResponse login(SignRequest request) throws Exception {
        User user = userRepository.findByUserId(request.getUserid()).orElseThrow(() ->
                new BadCredentialsException("잘못된 계정정보입니다."));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassWord())) {
            throw new BadCredentialsException("잘못된 계정정보입니다.");
        }

        return SignResponse.builder()
                .userId(user.getUserId())
                .nickname(user.getNickName())
                .roles(user.getRoles())
                .token(jwtProvider.createToken(user.getUserId(), user.getRoles()))
                .build();

    }

    public boolean register(SignRequest request) throws Exception {
        try {
            User user = User.builder()
                    .userId(request.getUserid())
                    .passWord(passwordEncoder.encode(request.getPassword()))
                    .nickName(request.getNickname())
                    .build();

            user.setRoles(Collections.singletonList(Authority.builder().name("ROLE_USER").build()));

            userRepository.save(user);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("잘못된 요청입니다.");
        }
        return true;
    }

    public SignResponse getUser(String id) throws Exception {
        User user = userRepository.findByUserId(id)
                .orElseThrow(() -> new Exception("계정을 찾을 수 없습니다."));
        return new SignResponse(user);
    }

}
