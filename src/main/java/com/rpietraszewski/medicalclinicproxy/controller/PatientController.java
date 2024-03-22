package com.rpietraszewski.medicalclinicproxy.controller;

import com.rpietraszewski.medicalclinicproxy.model.dto.PatientCreateDTO;
import com.rpietraszewski.medicalclinicproxy.model.dto.PatientDTO;
import com.rpietraszewski.medicalclinicproxy.model.dto.VisitDTO;
import com.rpietraszewski.medicalclinicproxy.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/patients")
@RequiredArgsConstructor
public class PatientController {
    private final PatientService patientService;

    @GetMapping("/{id}")
    public PatientDTO getPatient(@PathVariable("id") Long id) {
        return patientService.getPatient(id);
    }

    @GetMapping(params = "date")
    public List<PatientDTO> getPatientsFromDate(@RequestParam LocalDate date){
        return patientService.getPatientsFromDate(date);
    }

    @GetMapping
    public List<PatientDTO> getPatients(){
        return patientService.getPatients();
    }

    @PostMapping
    public PatientDTO createPatient(@RequestBody PatientCreateDTO patientCreateDTO){
        return patientService.createPatient(patientCreateDTO);
    }

    @GetMapping("/{patientId}/visits")
    public List<VisitDTO> getVisitsForPatient(@PathVariable("patientId") Long id){
        return patientService.getVisitsForPatient(id);
    }
}