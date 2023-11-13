package com.example.subsub.dto.request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@AllArgsConstructor
public class UpdatePropertyRequest {

    private final LocalDate expiredAt;
    private final String content;
    private final Boolean isCompleted;
}
