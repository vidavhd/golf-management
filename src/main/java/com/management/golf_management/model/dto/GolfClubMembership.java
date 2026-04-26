package com.management.golf_management.model.dto;

import com.management.golf_management.utils.DatabaseEnums;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;

@Entity
@Table(name = "golfclubmembership",
        uniqueConstraints = @UniqueConstraint(name="uq_gcm_player_course",
                columnNames = {"player_id","course_id"}))
@Getter
@Setter
@ToString
public class GolfClubMembership {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "membership_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "player_id", referencedColumnName = "player_id", nullable = false)
    private Player player;

    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "course_id", referencedColumnName = "course_id", nullable = false)
    private GolfCourse course;

    @Enumerated(EnumType.STRING)
    @Column(name = "membership_type", nullable = false)
    private DatabaseEnums.MembershipType membershipType;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private DatabaseEnums.MembershipStatus status = DatabaseEnums.MembershipStatus.ACTIVE;

    @Column(name = "created_at", updatable = false, insertable = false)
    private Timestamp createdAt;
}