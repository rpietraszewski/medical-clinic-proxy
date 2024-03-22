package com.rpietraszewski.medicalclinicproxy.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class MedicalClinicProxyException extends RuntimeException {
    private final HttpStatus httpStatus;

    public MedicalClinicProxyException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}