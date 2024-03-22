package com.rpietraszewski.medicalclinicproxy.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class MessageDTO {
    private String message;
    private LocalDate date;
    private HttpStatus httpStatus;
}