package com.management.golf_management.model.response;

import com.management.golf_management.utils.DatabaseEnums;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerRegisterResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private DatabaseEnums.SkillLevel skillLevel;
    private String message;
}
