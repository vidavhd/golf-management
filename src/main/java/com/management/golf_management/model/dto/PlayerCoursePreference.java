package com.management.golf_management.model.dto;

import com.management.golf_management.utils.DatabaseEnums.Season;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;

@Entity
@Table(name = "PlayerCoursePreference",
        uniqueConstraints = {
                @UniqueConstraint(name = "UQ_PC_PREF_PLAYER_COURSE_SEASON",
                        columnNames = {"PLAYER_ID","COURSE_ID","SEASON"}),
                @UniqueConstraint(name = "UQ_PC_PREF_PLAYER_SEASON_RANK",
                        columnNames = {"PLAYER_ID","SEASON","PREFERENCE_RANK"})
        })
@Getter
@Setter
@ToString
public class PlayerCoursePreference {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PREFERENCE_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "PLAYER_ID", nullable = false)
    private Player player;

    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "COURSE_ID", nullable = false)
    private GolfCourse course;

    @Enumerated(EnumType.STRING)
    @Column(name = "SEASON", nullable = false)
    private Season season;

    @Column(name = "PREFERENCE_TYPE", nullable = false, length = 10)
    private String preferenceType; // or an enum if you prefer

    @Column(name = "PREFERENCE_RANK", nullable = false)
    private Integer preferenceRank;

    @Column(name = "NOTES", length = 255)
    private String notes;

    @Column(name = "CREATED_AT", updatable = false, insertable = false)
    private Timestamp createdAt;
}

