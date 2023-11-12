package com.example.subsub.dto.response;

import com.example.subsub.domain.Property;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
public class PropertyResponse {

    private final LocalDate expiredAt;
    private final String content;
    private final Boolean isCompleted;

    public PropertyResponse(Property property){
        this.expiredAt = property.getExpiredAt();
        this.content = property.getContent();
        this.isCompleted = property.getIsCompleted();
    }
}
