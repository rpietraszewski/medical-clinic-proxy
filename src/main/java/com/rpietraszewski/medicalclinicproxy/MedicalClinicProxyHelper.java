package com.rpietraszewski.medicalclinicproxy;

import com.rpietraszewski.medicalclinicproxy.model.dto.AssignVisitCommandDTO;
import com.rpietraszewski.medicalclinicproxy.model.dto.PatientCreateDTO;

import java.util.Objects;
import java.util.stream.Stream;

public class MedicalClinicProxyHelper {
    public static boolean patientHasNullFields(PatientCreateDTO patient) {
        return Stream.of(patient.getEmail(),
                        patient.getPhoneNumber(),
                        patient.getFirstName(),
                        patient.getLastName(),
                        patient.getIdCardNo(),
                        patient.getPassword(),
                        patient.getBirthday())
                .anyMatch(Objects::isNull);
    }

    public static boolean assignVisitHasNullFields(AssignVisitCommandDTO assignVisit) {
        return Stream.of(assignVisit.getDoctorEmail(),
                        assignVisit.getInstitution(),
                        assignVisit.getPatientId(),
                        assignVisit.getStartDateTime(),
                        assignVisit.getEndDateTime())
                .anyMatch(Objects::isNull);
    }
}