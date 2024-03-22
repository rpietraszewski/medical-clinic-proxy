package com.rpietraszewski.medicalclinicproxy.service;

import com.rpietraszewski.medicalclinicproxy.MedicalClinicProxyHelper;
import com.rpietraszewski.medicalclinicproxy.exception.AssignVisitNullFieldsException;
import com.rpietraszewski.medicalclinicproxy.model.dto.AssignPatientCommandDTO;
import com.rpietraszewski.medicalclinicproxy.model.dto.AssignVisitCommandDTO;
import com.rpietraszewski.medicalclinicproxy.model.dto.VisitCreateDTO;
import com.rpietraszewski.medicalclinicproxy.model.dto.VisitDTO;
import com.rpietraszewski.medicalclinicproxy.remote.MedicalClinicClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VisitService {
    private final MedicalClinicClient medicalClinicClient;

    public VisitDTO createAssignedVisit(AssignVisitCommandDTO assignVisitCommandDTO){
        if(MedicalClinicProxyHelper.assignVisitHasNullFields(assignVisitCommandDTO)){
            throw new AssignVisitNullFieldsException("Given values cannot be empty");
        }

        VisitCreateDTO newVisit = VisitCreateDTO.builder()
                .startDateTime(assignVisitCommandDTO.getStartDateTime())
                .endDateTime(assignVisitCommandDTO.getEndDateTime())
                .institution(assignVisitCommandDTO.getInstitution())
                .doctorEmail(assignVisitCommandDTO.getDoctorEmail())
                .build();

        VisitDTO visitDTO = medicalClinicClient.createVisit(newVisit);

        AssignPatientCommandDTO newPatient = AssignPatientCommandDTO.builder()
                .patientId(assignVisitCommandDTO.getPatientId())
                .build();

        return medicalClinicClient.assignPatientToVisit(visitDTO.getId(), newPatient);
    }
}