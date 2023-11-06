package com.example.subsub.domain;
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

}
