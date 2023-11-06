package com.example.subsub.domain;

import com.example.subsub.dto.request.AddPropertyRequest;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Builder
@AllArgsConstructor
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer propertyId;

    @Column(nullable = false)
    private LocalDateTime expiredAt;

    @Column(nullable = false)
    private String content;

    @ManyToOne
    private Subject subject;

    public static Property of(AddPropertyRequest request, Subject subject){
        return Property.builder()
                .expiredAt(request.getExpiredAt())
                .content(request.getContent())
                .subject(subject)
                .build();
    }
}
