package com.rpietraszewski.medicalclinicproxy.exception;

import org.springframework.http.HttpStatus;

public class PatientIdNullException extends MedicalClinicProxyException {
    public PatientIdNullException(String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }
}
