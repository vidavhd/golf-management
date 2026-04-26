package com.management.golf_management.model.dto;

import com.management.golf_management.utils.DatabaseEnums;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "player", uniqueConstraints = {
        @UniqueConstraint(name = "uk_player_email", columnNames = "email"),
        @UniqueConstraint(name = "uk_player_phone", columnNames = "phone")
})
@Getter
@Setter
@ToString
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "player_id")
    private Integer id;

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private DatabaseEnums.Gender gender = DatabaseEnums.Gender.OTHER;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Column(name = "phone", length = 20)
    private String phone;

    @Column(name = "state", length = 50)
    private String state;

    @Column(name = "country", length = 50)
    private String country;

    @Column(name = "handicap", nullable = false, precision = 4, scale = 1)
    private BigDecimal handicap;

    @Column(name = "age")
    private Integer age;

    @Enumerated(EnumType.STRING)
    @Column(name = "skill_level", nullable = false)
    private DatabaseEnums.SkillLevel skillLevel;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private Timestamp createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Timestamp updatedAt;
}
