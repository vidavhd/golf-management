package com.management.golf_management.model.dto;

import com.management.golf_management.utils.DatabaseEnums;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;
import java.time.LocalDate;

@Entity
@Table(name = "MatchHistory")
@Getter
@Setter
@ToString
public class MatchHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MATCH_HISTORY_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "PLAYER1_ID", nullable = false)
    private Player player1;

    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "PLAYER2_ID", nullable = false)
    private Player player2;

    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "COURSE_ID", nullable = false)
    private GolfCourse course;

    @Enumerated(EnumType.STRING)
    @Column(name = "MATCH_TYPE", nullable = false)
    private DatabaseEnums.MatchType matchType; // Use STROKE_PLAY etc.

    @Column(name = "MATCH_DATE", nullable = false)
    private LocalDate matchDate;

    @Column(name = "HOLES_PLAYED", nullable = false)
    private Integer holesPlayed;

    @Enumerated(EnumType.STRING)
    @Column(name = "RESULT")
    private DatabaseEnums.MatchResult result = DatabaseEnums.MatchResult.TIE;

    @Column(name = "CREATED_AT", updatable = false, insertable = false)
    private Timestamp createdAt;
}
