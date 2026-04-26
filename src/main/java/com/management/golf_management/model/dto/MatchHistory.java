package com.management.golf_management.model.dto;

import com.management.golf_management.utils.DatabaseEnums;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;
import java.time.LocalDate;

@Entity
@Table(name = "matchhistory")
@Getter
@Setter
@ToString
public class MatchHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "match_history_id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "player1_id", referencedColumnName = "player_id", nullable = false)
    private Player player1;

    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "player2_id", referencedColumnName = "player_id", nullable = false)
    private Player player2;

    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "course_id", referencedColumnName = "course_id", nullable = false)
    private GolfCourse course;

    @Enumerated(EnumType.STRING)
    @Column(name = "match_type", nullable = false)
    private DatabaseEnums.MatchType matchType; // Use STROKE_PLAY etc.

    @Column(name = "match_date", nullable = false)
    private LocalDate matchDate;

    @Column(name = "holes_played", nullable = false)
    private Integer holesPlayed;

    @Enumerated(EnumType.STRING)
    @Column(name = "result")
    private DatabaseEnums.MatchResult result = DatabaseEnums.MatchResult.TIE;

    @Column(name = "created_at", updatable = false, insertable = false)
    private Timestamp createdAt;
}
