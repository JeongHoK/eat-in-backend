package com.eatin.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Table(name = "users")
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false, unique = true)
    private String nickName;

    @Column(nullable = false, unique = true)
    private String email;

    private String password;  // 비번 암호화는 나중에

    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    private LocalDateTime joinDate;

    public enum UserRole {
        USER, ADMIN
    }

    @OneToMany(mappedBy = "user")
    private List<Program> programs;

    @OneToMany(mappedBy = "user")
    private List<ProgramApplication> programApplications;

    @OneToMany(mappedBy = "user")
    private List<ProgramReview> programReviews;
}
