package com.management.golf_management.model.dto;

import com.management.golf_management.utils.DatabaseEnums;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "Player", uniqueConstraints = {
        @UniqueConstraint(name = "UK_PLAYER_EMAIL", columnNames = "EMAIL"),
        @UniqueConstraint(name = "UK_PLAYER_PHONE", columnNames = "PHONE")
})
@Getter
@Setter
@ToString
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PLAYER_ID")
    private Long id;

    @Column(name = "FIRST_NAME", nullable = false, length = 50)
    private String firstName;

    @Column(name = "LAST_NAME", nullable = false, length = 50)
    private String lastName;

    @Enumerated(EnumType.STRING)
    @Column(name = "GENDER")
    private DatabaseEnums.Gender gender = DatabaseEnums.Gender.OTHER;

    @Column(name = "EMAIL", nullable = false, length = 100)
    private String email;

    @Column(name = "PHONE", length = 20)
    private String phone;

    @Column(name = "STATE", length = 50)
    private String state;

    @Column(name = "COUNTRY", length = 50)
    private String country;

    @Column(name = "HANDICAP", nullable = false, precision = 4, scale = 1)
    private BigDecimal handicap;

    @Column(name = "AGE")
    private Integer age;

    @Enumerated(EnumType.STRING)
    @Column(name = "SKILL_LEVEL", nullable = false)
    private DatabaseEnums.SkillLevel skillLevel;

    @Column(name = "CREATED_AT", updatable = false, insertable = false)
    private Timestamp createdAt;

    @Column(name = "UPDATED_AT", insertable = false)
    private Timestamp updatedAt;
}

