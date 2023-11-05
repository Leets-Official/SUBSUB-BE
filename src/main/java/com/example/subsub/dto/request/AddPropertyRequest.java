package com.example.subsub.dto.request;

import com.example.subsub.domain.Property;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class AddPropertyRequest {

    private final LocalDateTime expiredAt;
    private final String content;
    private final Integer subjectId;

    public Property toEntity() {
        return Property.builder()
                .expiredAt(expiredAt)
                .content(content)
                .subjectId(subjectId)
                .build();
    }
}
