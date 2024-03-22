package com.rpietraszewski.medicalclinicproxy.remote;

import com.rpietraszewski.medicalclinicproxy.FeignConfiguration;
import com.rpietraszewski.medicalclinicproxy.model.dto.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@FeignClient(name = "medicalClinicClient", configuration = FeignConfiguration.class)
public interface MedicalClinicClient {

    @GetMapping("/patients/{id}")
    PatientDTO getPatient(@PathVariable("id") Long id);

    @GetMapping(value = "/patients" , params = "date")
    List<PatientDTO> getPatientsFromDate(@RequestParam LocalDate date);

    @GetMapping("/patients")
    List<PatientDTO> getPatients();

    @PostMapping("/patients")
    PatientDTO createPatient(@RequestBody PatientCreateDTO patientCreateDTO);

    @GetMapping("/visits/{patientId}")
    List<VisitDTO> getVisitsForPatient(@PathVariable("patientId") Long id);

    @PostMapping("/visits")
    VisitDTO createVisit(@RequestBody VisitCreateDTO visitCreateDTO);

    @PatchMapping("/visits/{id}")
    VisitDTO assignPatientToVisit(@PathVariable("id") Long visitId, @RequestBody AssignPatientCommandDTO assignPatientCommandDTO);
}