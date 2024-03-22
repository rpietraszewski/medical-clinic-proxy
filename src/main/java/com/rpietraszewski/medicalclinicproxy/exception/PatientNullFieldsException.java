package com.rpietraszewski.medicalclinicproxy.exception;

import org.springframework.http.HttpStatus;

public class PatientNullFieldsException extends MedicalClinicProxyException {
    public PatientNullFieldsException(String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }
}