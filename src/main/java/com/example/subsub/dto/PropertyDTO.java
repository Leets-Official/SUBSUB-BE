package com.example.subsub.dto;

import com.example.subsub.domain.Property;
import com.example.subsub.domain.Subject;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class PropertyDTO {

    private Integer propertyId;
    private LocalDateTime expiredAt;
    private String content;
    private Subject subject;

    public static PropertyDTO toPropertyDto(Property property){
        PropertyDTO propertyDTO = new PropertyDTO();
        propertyDTO.propertyId = property.getPropertyId();
        propertyDTO.expiredAt = property.getExpiredAt();
        propertyDTO.content = property.getContent();
        propertyDTO.subject = property.getSubject();
        return propertyDTO;
    }
}
