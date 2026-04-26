package com.management.golf_management.model.dto;

import com.management.golf_management.utils.DatabaseEnums;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "golfcourse", uniqueConstraints = {
        @UniqueConstraint(name = "uk_course_loc", columnNames = {"course_name","city","state","country"})
})
@Getter
@Setter
@ToString
public class GolfCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private Integer id;

    @Column(name = "course_name", nullable = false, length = 100)
    private String name;

    @Column(name = "city", length = 50)
    private String city;

    @Column(name = "state", length = 50)
    private String state;

    @Column(name = "country", nullable = false, length = 50)
    private String country;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private DatabaseEnums.CourseType type;

    @Enumerated(EnumType.STRING)
    @Column(name = "difficulty")
    private DatabaseEnums.Difficulty difficulty;

    @Column(name = "holes")
    private Integer holes;

    @Column(name = "slope_rating")
    private Integer slopeRating;

    @Column(name = "course_rating", precision = 4, scale = 1)
    private BigDecimal courseRating;

    @Column(name = "created_at", updatable = false, insertable = false)
    private Timestamp createdAt;
}