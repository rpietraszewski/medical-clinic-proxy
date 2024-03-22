package com.rpietraszewski.medicalclinicproxy;

import com.rpietraszewski.medicalclinicproxy.model.dto.PatientCreateDTO;
import com.rpietraszewski.medicalclinicproxy.model.dto.PatientDTO;
import com.rpietraszewski.medicalclinicproxy.model.dto.VisitDTO;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TestDataFactory {
    public static PatientDTO createPatientDTO(Long id, String email){
        return PatientDTO.builder()
                .id(id)
                .email(email)
                .firstName("patientName")
                .lastName("patientLastName")
                .build();
    }

    public static PatientCreateDTO createPatientCreateDTO(Long id, String email, String idCardNo){
        return PatientCreateDTO.builder()
                .email(email)
                .firstName("patientName")
                .lastName("patientLastName")
                .idCardNo(idCardNo)
                .password("patientPassword")
                .phoneNumber("patientPhone")
                .birthday(LocalDate.now())
                .build();
    }

    public static VisitDTO createVisitDTO(Long id, Long patientId, String doctorEmail){
        return VisitDTO.builder()
                .id(id)
                .startDateTime(LocalDateTime.of(2024,3,18,15,0))
                .endDateTime(LocalDateTime.of(2024,4,18,18,0))
                .doctorEmail(doctorEmail)
                .institution(1L)
                .patientId(patientId)
                .build();
    }
}
