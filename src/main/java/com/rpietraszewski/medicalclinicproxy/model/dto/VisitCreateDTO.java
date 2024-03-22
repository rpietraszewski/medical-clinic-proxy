package com.rpietraszewski.medicalclinicproxy.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Builder
@Setter
@Getter
@AllArgsConstructor
public class VisitCreateDTO {
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private Long institution;
    private String doctorEmail;
}
