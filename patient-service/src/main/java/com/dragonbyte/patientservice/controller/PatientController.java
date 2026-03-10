package com.dragonbyte.patientservice.controller;

import com.dragonbyte.patientservice.dto.PatientRequestDTO;
import com.dragonbyte.patientservice.dto.PatientResponseDto;
import com.dragonbyte.patientservice.service.PatientService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/patients")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public ResponseEntity<List<PatientResponseDto>> getPatients() {
        List<PatientResponseDto> patients = patientService.getPatients();
        return ResponseEntity.ok().body(patients);
    }

    @PostMapping
    public ResponseEntity<PatientResponseDto> createPatient(@Valid @RequestBody PatientRequestDTO patientRequestDTO) {
        PatientResponseDto patient = patientService.createPatient(patientRequestDTO);
        return ResponseEntity.ok().body(patient);
    }

}
