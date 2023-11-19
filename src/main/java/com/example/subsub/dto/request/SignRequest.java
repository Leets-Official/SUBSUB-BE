package com.example.subsub.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignRequest {

    private Long id;

    private String userId;

    private String nickName;

    private String passWord;
}
