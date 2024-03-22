package com.rpietraszewski.medicalclinicproxy.service;

import com.rpietraszewski.medicalclinicproxy.TestDataFactory;
import com.rpietraszewski.medicalclinicproxy.exception.DateNullException;
import com.rpietraszewski.medicalclinicproxy.exception.PatientIdNullException;
import com.rpietraszewski.medicalclinicproxy.exception.PatientNullFieldsException;
import com.rpietraszewski.medicalclinicproxy.model.dto.PatientCreateDTO;
import com.rpietraszewski.medicalclinicproxy.model.dto.PatientDTO;
import com.rpietraszewski.medicalclinicproxy.model.dto.VisitDTO;
import com.rpietraszewski.medicalclinicproxy.remote.MedicalClinicClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class PatientServiceTest {
    MedicalClinicClient medicalClinicClient;
    PatientService patientService;

    @BeforeEach
    void setup() {
        this.medicalClinicClient = Mockito.mock(MedicalClinicClient.class);
        this.patientService = new PatientService(medicalClinicClient);
    }

    @Test
    void getPatient_DataCorrect_PatientDtoReturned() {
        PatientDTO patientDTO = TestDataFactory.createPatientDTO(1L, "patient@patient.pl");

        when(medicalClinicClient.getPatient(1L)).thenReturn(patientDTO);

        PatientDTO result = patientService.getPatient(1L);

        assertEquals(1L, result.getId());
        assertEquals("patient@patient.pl", result.getEmail());
        assertEquals("patientName", result.getFirstName());
        assertEquals("patientLastName", result.getLastName());
    }

    @Test
    void getPatientFromDate_DataCorrect_ListPatientsDtoReturned() {
        PatientDTO patientDTO1 = TestDataFactory.createPatientDTO(1L, "patient@patient.pl");
        PatientDTO patientDTO2 = TestDataFactory.createPatientDTO(2L, "patient@patient.pl");

        when(medicalClinicClient.getPatientsFromDate(LocalDate.now())).thenReturn(List.of(patientDTO1, patientDTO2));

        List<PatientDTO> result = patientService.getPatientsFromDate(LocalDate.now());

        assertEquals(1L, result.get(0).getId());
        assertEquals("patient@patient.pl", result.get(0).getEmail());
        assertEquals("patientName", result.get(0).getFirstName());
        assertEquals("patientLastName", result.get(0).getLastName());

        assertEquals(2L, result.get(1).getId());
        assertEquals("patient@patient.pl", result.get(1).getEmail());
        assertEquals("patientName", result.get(1).getFirstName());
        assertEquals("patientLastName", result.get(1).getLastName());
    }

    @Test
    void getPatients_DataCorrect_ListPatientsDtoReturned() {
        PatientDTO patientDTO1 = TestDataFactory.createPatientDTO(1L, "patient@patient.pl");
        PatientDTO patientDTO2 = TestDataFactory.createPatientDTO(2L, "patient@patient.pl");

        when(medicalClinicClient.getPatients()).thenReturn(List.of(patientDTO1, patientDTO2));

        List<PatientDTO> result = patientService.getPatients();

        assertEquals(1L, result.get(0).getId());
        assertEquals("patient@patient.pl", result.get(0).getEmail());
        assertEquals("patientName", result.get(0).getFirstName());
        assertEquals("patientLastName", result.get(0).getLastName());

        assertEquals(2L, result.get(1).getId());
        assertEquals("patient@patient.pl", result.get(1).getEmail());
        assertEquals("patientName", result.get(1).getFirstName());
        assertEquals("patientLastName", result.get(1).getLastName());
    }

    @Test
    void createPatient_DataCorrect_PatientDtoReturned() {
        PatientCreateDTO patientCreateDTO = TestDataFactory.createPatientCreateDTO(1L,
                "patient@patient.pl",
                "idCardNo"
        );

        PatientDTO patientDTO = TestDataFactory.createPatientDTO(1L, "patient@patient.pl");

        when(medicalClinicClient.createPatient(any())).thenReturn(patientDTO);

        PatientDTO result = patientService.createPatient(patientCreateDTO);

        assertEquals(1L, result.getId());
        assertEquals("patient@patient.pl", result.getEmail());
        assertEquals("patientName", result.getFirstName());
        assertEquals("patientLastName", result.getLastName());
    }

    @Test
    void getVisitsForPatient_DataCorrect_ListVisitsDtoReturned() {
        VisitDTO visitDTO = TestDataFactory.createVisitDTO(1L, 1L, "doctor@doctor.pl");

        when(medicalClinicClient.getVisitsForPatient(1L)).thenReturn(List.of(visitDTO));

        List<VisitDTO> result = patientService.getVisitsForPatient(1L);

        assertEquals(1L, result.get(0).getId());
        assertEquals("doctor@doctor.pl", result.get(0).getDoctorEmail());
        assertEquals(1L, result.get(0).getPatientId());
    }

    @Test
    void getPatient_PatientIdNull_PatientIdNullExceptionThrown() {
        PatientIdNullException exception = Assertions.assertThrows(PatientIdNullException.class,
                () -> patientService.getPatient(null));

        assertEquals("Given id cannot be empty", exception.getMessage());
        assertEquals(HttpStatus.BAD_REQUEST, exception.getHttpStatus());
    }

    @Test
    void getPatientsFromDate_DateNull_DateNullExceptionThrown() {
        DateNullException exception = Assertions.assertThrows(DateNullException.class,
                () -> patientService.getPatientsFromDate(null));

        assertEquals("Given date cannot be empty", exception.getMessage());
        assertEquals(HttpStatus.BAD_REQUEST, exception.getHttpStatus());
    }

    @Test
    void createPatient_PatientNullFields_PatientNullFieldsExceptionThrown() {
        PatientCreateDTO patientCreateDTO = TestDataFactory.createPatientCreateDTO(null,null,null);

        PatientNullFieldsException exception = Assertions.assertThrows(PatientNullFieldsException.class,
                () -> patientService.createPatient(patientCreateDTO));

        assertEquals("Created patient cannot have empty values", exception.getMessage());
        assertEquals(HttpStatus.BAD_REQUEST, exception.getHttpStatus());
    }

    @Test
    void getVisitsForPatient_PatientIdNull_PatientIdNullExceptionThrown(){
        PatientIdNullException exception = Assertions.assertThrows(PatientIdNullException.class,
                () -> patientService.getVisitsForPatient(null));

        assertEquals("Given id cannot be empty", exception.getMessage());
        assertEquals(HttpStatus.BAD_REQUEST, exception.getHttpStatus());
    }
}