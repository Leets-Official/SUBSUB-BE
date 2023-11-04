package com.example.subsub.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false,nullable = false)
    private int id;

    @Column(nullable = false)
    private LocalDateTime expired_at;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name="subject_id")
    private Subject subjectId;
}
