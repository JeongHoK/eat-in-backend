package com.eatin.domain;

import com.eatin.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
@Table(name = "users")
public class User extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String fullName;

    @Column(nullable = false, unique = true, length = 100)
    private String nickName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column
    private String password;  // 비번 암호화는 나중에

    @Column(nullable = false, length = 20)
    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    public enum UserRole {
        APPLICANT, HOST, ADMIN
    }

    @Column(nullable = false)
    private LocalDateTime joinDate;

    @OneToMany(mappedBy = "user")
    private List<Program> programs;

    @OneToMany(mappedBy = "user")
    private List<ProgramApplication> programApplications;

    @OneToMany(mappedBy = "user")
    private List<ProgramReview> programReviews;
}
