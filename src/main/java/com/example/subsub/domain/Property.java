package com.example.subsub.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false,nullable = false)
    private Integer id;

    @Column(nullable = false)
    private LocalDateTime expiredAt;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "subject_id")
    private Subject subjectId;

    @Builder
    private Property(LocalDateTime expiredAt, String content, Subject subjectId) {
        this.expiredAt = expiredAt;
        this.content = content;
        this.subjectId = subjectId;
    }
}
