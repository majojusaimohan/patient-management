package com.dragonbyte.patientservice.service;

import com.dragonbyte.patientservice.dto.PatientResponseDto;
import com.dragonbyte.patientservice.model.Patient;
import com.dragonbyte.patientservice.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public  List<PatientResponseDto> getPatients(){
        List<Patient> patients= patientRepository.findAll();
    }
}
