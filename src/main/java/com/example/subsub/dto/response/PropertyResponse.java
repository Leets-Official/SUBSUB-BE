package com.example.subsub.dto.response;

import com.example.subsub.domain.Property;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class PropertyResponse {

    private final Integer propertyId;
    private final LocalDate expiredAt;
    private final String content;
    private final Boolean isCompleted;

    public PropertyResponse(Property property){
        this.propertyId = property.getPropertyId();
        this.expiredAt = property.getExpiredAt();
        this.content = property.getContent();
        this.isCompleted = property.getIsCompleted();
    }
}
