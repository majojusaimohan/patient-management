package com.dragonbyte.patientservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class PatientRequestDTO {

    @NotBlank
    @Size(max = 100, message="Name cannot exceed 100 characters")
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    private String email;

    @NotNull(message = "Date of Birth is required")
    private String dateOfBirth;

    @NotBlank(message = "Address is required")
    private String address;

    @NotNull(message = "Registered date is required")
    private String registeredDate;
}
