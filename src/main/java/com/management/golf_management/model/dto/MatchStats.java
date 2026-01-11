package com.management.golf_management.model.dto;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;

@Entity
@Table(name = "MatchStats",
        uniqueConstraints = @UniqueConstraint(name="UQ_MATCHSTATS_PLAYER_MATCH",
                columnNames = {"MATCH_HISTORY_ID","PLAYER_ID"}))
@Getter
@Setter
@ToString
public class MatchStats {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MATCH_STATS_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "MATCH_HISTORY_ID", nullable = false)
    private MatchHistory match;

    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "PLAYER_ID", nullable = false)
    private Player player;

    @Column(name = "STROKES", nullable = false) private Integer strokes;
    @Column(name = "NET_SCORE") private Integer netScore;
    @Column(name = "PUTTS") private Integer putts;
    @Column(name = "GREENS_IN_REGULATION") private Integer gir;
    @Column(name = "FAIRWAYS_HIT") private Integer fairwaysHit;
    @Column(name = "BIRDIES") private Integer birdies = 0;
    @Column(name = "PARS") private Integer pars = 0;
    @Column(name = "BOGEYS") private Integer bogeys = 0;
    @Column(name = "DOUBLE_BOGEYS") private Integer doubleBogeys = 0;
    @Column(name = "TRIPLE_BOGEYS") private Integer tripleBogeys = 0;
    @Column(name = "OTHERS") private Integer others = 0;
    @Column(name = "SCORE_RELATIVE_PAR") private Integer scoreRelativePar;

    @Column(name = "CREATED_AT", updatable = false, insertable = false)
    private Timestamp createdAt;
}
