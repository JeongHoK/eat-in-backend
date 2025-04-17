package com.eatin.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Table(name = "programs")
public class Program {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String title;

    private String description;

    private Integer recruitCount;

    private LocalDateTime recruitStartDate;

    private LocalDateTime recruitEndDate;

    private LocalDateTime recruitAnnouncementDate;

    private LocalDateTime reviewStartDate;

    private LocalDateTime reviewEndDate;

    private LocalDateTime registeredDate;

    @OneToMany(mappedBy = "program")
    private List<ProgramApplication> programApplications;

    @OneToMany(mappedBy = "program")
    private List<ProgramReview> programReviews;
}
