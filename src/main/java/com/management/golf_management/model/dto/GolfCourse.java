package com.management.golf_management.model.dto;

import com.management.golf_management.utils.DatabaseEnums;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "GolfCourse", uniqueConstraints = {
        @UniqueConstraint(name = "UK_COURSE_LOC", columnNames = {"COURSE_NAME","CITY","STATE","COUNTRY"})
})
@Getter
@Setter
@ToString
public class GolfCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COURSE_ID")
    private Long id;

    @Column(name = "COURSE_NAME", nullable = false, length = 100)
    private String name;

    @Column(name = "CITY", length = 50) private String city;
    @Column(name = "STATE", length = 50) private String state;

    @Column(name = "COUNTRY", nullable = false, length = 50)
    private String country;

    @Enumerated(EnumType.STRING)
    @Column(name = "TYPE", nullable = false)
    private DatabaseEnums.CourseType type;

    @Enumerated(EnumType.STRING)
    @Column(name = "DIFFICULTY")
    private DatabaseEnums.Difficulty difficulty;

    @Column(name = "HOLES") private Integer holes;

    @Column(name = "SLOPE_RATING") private Integer slopeRating;
    @Column(name = "COURSE_RATING", precision = 4, scale = 1) private BigDecimal courseRating;

    @Column(name = "CREATED_AT", updatable = false, insertable = false)
    private Timestamp createdAt;
}

