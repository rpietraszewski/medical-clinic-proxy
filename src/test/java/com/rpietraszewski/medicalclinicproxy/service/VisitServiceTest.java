package com.rpietraszewski.medicalclinicproxy.service;

import com.rpietraszewski.medicalclinicproxy.remote.MedicalClinicClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class VisitServiceTest {
    MedicalClinicClient medicalClinicClient;
    VisitService visitService;

    @BeforeEach
    void setup(){
        this.medicalClinicClient = Mockito.mock(MedicalClinicClient.class);
        this.visitService = new VisitService(medicalClinicClient);
    }

    @Test
    void createAssignedVisit_DataCorrect_VisitDtoReturned(){
        
    }
}
