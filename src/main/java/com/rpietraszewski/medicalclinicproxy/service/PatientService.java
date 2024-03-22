package com.rpietraszewski.medicalclinicproxy.service;

import com.rpietraszewski.medicalclinicproxy.MedicalClinicProxyHelper;
import com.rpietraszewski.medicalclinicproxy.exception.DateNullException;
import com.rpietraszewski.medicalclinicproxy.exception.PatientIdNullException;
import com.rpietraszewski.medicalclinicproxy.exception.PatientNullFieldsException;
import com.rpietraszewski.medicalclinicproxy.model.dto.PatientCreateDTO;
import com.rpietraszewski.medicalclinicproxy.model.dto.PatientDTO;
import com.rpietraszewski.medicalclinicproxy.model.dto.VisitDTO;
import com.rpietraszewski.medicalclinicproxy.remote.MedicalClinicClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientService {
    private final MedicalClinicClient medicalClinicClient;

    public PatientDTO getPatient(Long id){
        if(id == null){
            throw new PatientIdNullException("Given id cannot be empty");
        }

        return medicalClinicClient.getPatient(id);
    }

    public List<PatientDTO> getPatientsFromDate(LocalDate date){
        if(date == null){
            throw new DateNullException("Given date cannot be empty");
        }

        return medicalClinicClient.getPatientsFromDate(date);
    }

    public List<PatientDTO> getPatients(){
        return medicalClinicClient.getPatients();
    }

    public PatientDTO createPatient(PatientCreateDTO patientCreateDTO){
        if(MedicalClinicProxyHelper.patientHasNullFields(patientCreateDTO)){
            throw new PatientNullFieldsException("Created patient cannot have empty values");
        }

        return medicalClinicClient.createPatient(patientCreateDTO);
    }

    public List<VisitDTO> getVisitsForPatient(Long patientId){
        if(patientId == null){
            throw new PatientIdNullException("Given id cannot be empty");
        }

        return medicalClinicClient.getVisitsForPatient(patientId);
    }
}