package com.dragonbyte.patientservice.service;

import com.dragonbyte.patientservice.dto.PatientRequestDTO;
import com.dragonbyte.patientservice.dto.PatientResponseDto;
import com.dragonbyte.patientservice.exception.EmailAlreadyExistsException;
import com.dragonbyte.patientservice.exception.PatientNotFoundException;
import com.dragonbyte.patientservice.mapper.PatientMapper;
import com.dragonbyte.patientservice.model.Patient;
import com.dragonbyte.patientservice.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public  List<PatientResponseDto> getPatients(){
        List<Patient> patients= patientRepository.findAll();

        List<PatientResponseDto> patientResponseDTOs =
                patients.stream().map(PatientMapper::toDto).toList();

        return patientResponseDTOs;
    }

    public PatientResponseDto createPatient(PatientRequestDTO patientRequestDTO){

        if(patientRepository.existsByEmail(patientRequestDTO.getEmail())){
            throw new EmailAlreadyExistsException("A patient with this email already exists"+ patientRequestDTO.getEmail());
        }
        Patient newPatient = patientRepository.save(PatientMapper.toModel(patientRequestDTO));
        return PatientMapper.toDto(newPatient);
    }

    public PatientResponseDto updatePatient(UUID id, PatientRequestDTO patientRequestDTO){

        Patient patient= patientRepository.findById(id)
                .orElseThrow(()-> new PatientNotFoundException("Patient not found with id" +id));
        if(patientRepository.existsByEmailAndIdNot(patientRequestDTO.getEmail(),id)){
            throw new EmailAlreadyExistsException("A patient with this email already exists"+ patientRequestDTO.getEmail());
        }

        patient.setName(patientRequestDTO.getName());
        patient.setAddress(patientRequestDTO.getAddress());
        patient.setEmail(patientRequestDTO.getEmail());
        patient.setDateOfBirth(LocalDate.parse(patientRequestDTO.getDateOfBirth()));

        Patient updatedPatient = patientRepository.save(patient);
        return PatientMapper.toDto(updatedPatient);


    }

    public void deletePatient(UUID id){
        patientRepository.deleteById(id);
    }


}
