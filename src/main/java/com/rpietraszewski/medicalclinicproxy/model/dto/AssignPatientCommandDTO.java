package com.rpietraszewski.medicalclinicproxy.model.dto;

import lombok.*;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class AssignPatientCommandDTO {
    private Long patientId;
}
