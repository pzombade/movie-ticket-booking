package com.publicissapient.movieticketbooking.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    @Size(min=3, max = 10)
    private String userName;

    @Size(min=10)
    private String hashedPassword;

    @Email
    private String emailId;

    private int phone;

    @NotBlank
    private String zip;

}
