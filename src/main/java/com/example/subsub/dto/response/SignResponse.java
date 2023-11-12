package com.example.subsub.dto.response;

import com.example.subsub.domain.Authority;
import com.example.subsub.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SignResponse {
    private Long id;

    private String userId;

    private String nickname;

    private List<Authority> roles = new ArrayList<>();

    private String token;
    private Boolean result;
    private String message;

    public SignResponse(User user, Boolean result, String message) {
        this.id = user.getId();
        this.userId = user.getUserId();
        this.nickname = user.getNickName();
        this.roles = user.getRoles();
        this.result = result;
        this.message = message;

    }
}