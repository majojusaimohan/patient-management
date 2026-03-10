package com.dragonbyte.patientservice.mapper;

import com.dragonbyte.patientservice.dto.PatientResponseDto;
import com.dragonbyte.patientservice.model.Patient;

public class PatientMapper {

    public static PatientResponseDto toDto(Patient patient){

        PatientResponseDto patientResponseDto = new PatientResponseDto();
        patientResponseDto.setId(patient.getId().toString());
        patientResponseDto.setName(patient.getName());
        patientResponseDto.setAddress(patient.getAddress());
        patientResponseDto.setEmail(patient.getEmail());
        patientResponseDto.setDateOfBirth(patient.getDateOfBirth().toString());

        return patientResponseDto;


    }
}
