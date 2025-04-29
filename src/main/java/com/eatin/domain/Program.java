package com.eatin.domain;

import com.eatin.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
@Table(name = "programs")
public class Program extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false, length = 200)
    private String title;

    @Lob
    @Column
    private String description;

    @Column(nullable = false)
    private Integer recruitCount;

    @Column(nullable = false)
    private LocalDateTime recruitStartDate;

    @Column(nullable = false)
    private LocalDateTime recruitEndDate;

    @Column(nullable = false)
    private LocalDateTime recruitAnnouncementDate;

    @Column(nullable = false)
    private LocalDateTime reviewStartDate;

    @Column(nullable = false)
    private LocalDateTime reviewEndDate;

    @Column(nullable = false)
    private LocalDateTime registeredDate;

    @OneToMany(mappedBy = "program")
    private List<ProgramApplication> programApplications;

    @OneToMany(mappedBy = "program")
    private List<ProgramReview> programReviews;
}
