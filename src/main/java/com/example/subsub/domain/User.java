package com.example.subsub.domain;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "users")
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    @Column(nullable = false)
    private String userId;

    @Column(nullable = false)
    private String nickName;

    @Column(nullable = false)
    private String passWord;
}