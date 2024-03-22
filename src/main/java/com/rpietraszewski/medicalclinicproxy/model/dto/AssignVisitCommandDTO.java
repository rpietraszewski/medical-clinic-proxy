package com.rpietraszewski.medicalclinicproxy.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class AssignVisitCommandDTO {
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private Long institution;
    private String doctorEmail;
    private Long patientId;
}
