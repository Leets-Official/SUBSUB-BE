package com.example.subsub.domain;

import com.example.subsub.dto.request.AddPropertyRequest;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Integer id;

    @Column(nullable = false)
    private LocalDateTime expiredAt;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "subjectId")
    private Subject subject;

    @Column(name = "subjectId", updatable = false)
    private Integer subjectId;

    @Builder
    private Property(LocalDateTime expiredAt, String content, Subject subject, Integer subjectId) {
        this.expiredAt = expiredAt;
        this.content = content;
        this.subject = subject;
        this.subjectId = subjectId;
    }

    // Property의 request를 받아서 subject에 저장
    public static Property of(AddPropertyRequest request, Subject subject){
        return Property.builder()
                .expiredAt(request.getExpiredAt())
                .content(request.getContent())
                .subject(subject)
                .build();
    }
}
