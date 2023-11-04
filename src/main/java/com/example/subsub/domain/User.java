package com.example.subsub.domain;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class User {
    @Id
    @Column(updatable = false, nullable = false)
    private String userId;
    @Column(nullable = false)
    private String nickname;
    @Column(updatable = false, nullable = false)
    private String password;
}
