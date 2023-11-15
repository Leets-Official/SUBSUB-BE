package com.example.subsub.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class AddPropertyRequest {

    private final Integer subjectId;
    private final LocalDate expiredAt;
    private final String content;
    private final Boolean isCompleted;

}
