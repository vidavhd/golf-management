package com.management.golf_management.model.dto;

import com.management.golf_management.utils.DatabaseEnums;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;

@Entity
@Table(name = "GolfClubMembership",
        uniqueConstraints = @UniqueConstraint(name="UQ_GCM_PLAYER_COURSE",
                columnNames = {"PLAYER_ID","COURSE_ID"}))
@Getter
@Setter
@ToString
public class GolfClubMembership {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEMBERSHIP_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "PLAYER_ID", nullable = false)
    private Player player;

    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "COURSE_ID", nullable = false)
    private GolfCourse course;

    @Enumerated(EnumType.STRING)
    @Column(name = "MEMBERSHIP_TYPE", nullable = false)
    private DatabaseEnums.MembershipType membershipType;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS", nullable = false)
    private DatabaseEnums.MembershipStatus status = DatabaseEnums.MembershipStatus.ACTIVE;

    @Column(name = "CREATED_AT", updatable = false, insertable = false)
    private Timestamp createdAt;
}
