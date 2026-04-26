package com.management.golf_management.model.dto;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;

@Entity
@Table(name = "matchstats",
        uniqueConstraints = @UniqueConstraint(name="uq_matchstats_player_match",
                columnNames = {"match_history_id","player_id"}))
@Getter
@Setter
@ToString
public class MatchStats {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "match_stats_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "match_history_id", referencedColumnName = "match_history_id", nullable = false)
    private MatchHistory match;

    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "player_id", referencedColumnName = "player_id", nullable = false)
    private Player player;

    @Column(name = "strokes", nullable = false)
    private Integer strokes;

    @Column(name = "net_score")
    private Integer netScore;

    @Column(name = "putts")
    private Integer putts;

    @Column(name = "greens_in_regulation")
    private Integer gir;

    @Column(name = "fairways_hit")
    private Integer fairwaysHit;

    @Column(name = "birdies")
    private Integer birdies = 0;

    @Column(name = "pars")
    private Integer pars = 0;

    @Column(name = "bogeys")
    private Integer bogeys = 0;

    @Column(name = "double_bogeys")
    private Integer doubleBogeys = 0;

    @Column(name = "triple_bogeys")
    private Integer tripleBogeys = 0;

    @Column(name = "others")
    private Integer others = 0;

    @Column(name = "score_relative_par")
    private Integer scoreRelativePar;

    @Column(name = "created_at", updatable = false, insertable = false)
    private Timestamp createdAt;
}