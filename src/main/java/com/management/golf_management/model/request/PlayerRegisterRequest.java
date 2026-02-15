package com.management.golf_management.model.request;

import com.management.golf_management.utils.DatabaseEnums;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;

// PlayerRegisterRequest.java
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerRegisterRequest {
    @NotBlank(message = "First name is required")
    @Length(min = 2, max = 50)
    private String firstName;

    @NotBlank(message = "Last name is required")
    @Length(min = 2, max = 50)
    private String lastName;

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    private String email;

    @NotBlank(message = "Phone is required")
    @Pattern(regexp = "^[+]?[0-9]{10,}$", message = "Phone should be valid")
    private String phone;

    @NotNull(message = "Skill level is required")
    private DatabaseEnums.SkillLevel skillLevel;

    @NotNull(message = "Handicap is required")
    @DecimalMin(value = "-10.0", message = "Handicap must be >= -10.0")
    @DecimalMax(value = "54.0", message = "Handicap must be <= 54.0")
    private BigDecimal handicap;

    private DatabaseEnums.Gender gender;

    private Integer age;

    private String state;

    private String country;
}