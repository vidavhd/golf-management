package com.management.golf_management.model.dto;

import com.management.golf_management.utils.DatabaseEnums.Season;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;

@Entity
@Table(name = "playercoursereference",
        uniqueConstraints = {
                @UniqueConstraint(name = "uq_pc_pref_player_course_season",
                        columnNames = {"player_id","course_id","season"}),
                @UniqueConstraint(name = "uq_pc_pref_player_season_rank",
                        columnNames = {"player_id","season","preference_rank"})
        })
@Getter
@Setter
@ToString
public class PlayerCoursePreference {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "preference_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "player_id", referencedColumnName = "player_id", nullable = false)
    private Player player;

    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "course_id", referencedColumnName = "course_id", nullable = false)
    private GolfCourse course;

    @Enumerated(EnumType.STRING)
    @Column(name = "season", nullable = false)
    private Season season;

    @Column(name = "preference_type", nullable = false, length = 10)
    private String preferenceType;

    @Column(name = "preference_rank", nullable = false)
    private Integer preferenceRank;

    @Column(name = "notes", length = 255)
    private String notes;

    @Column(name = "created_at", updatable = false, insertable = false)
    private Timestamp createdAt;
}
