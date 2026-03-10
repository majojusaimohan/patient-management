package com.dragonbyte.patientservice.mapper;

import com.dragonbyte.patientservice.dto.PatientRequestDTO;
import com.dragonbyte.patientservice.dto.PatientResponseDto;
import com.dragonbyte.patientservice.model.Patient;

import java.time.LocalDate;

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

    public static Patient toModel(PatientRequestDTO patientRequestDTO){
        Patient patient= new Patient();

        patient.setName(patientRequestDTO.getName());
        patient.setAddress(patientRequestDTO.getAddress());
        patient.setEmail((patientRequestDTO.getEmail()));
        patient.setDateOfBirth(LocalDate.parse(patientRequestDTO.getDateOfBirth()));
        patient.setRegisteredDate(LocalDate.parse(patientRequestDTO.getRegisteredDate()));

        return patient;

    }
}
