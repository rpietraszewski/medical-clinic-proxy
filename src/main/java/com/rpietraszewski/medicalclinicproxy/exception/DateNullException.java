package com.rpietraszewski.medicalclinicproxy.exception;

import org.springframework.http.HttpStatus;

public class DateNullException extends MedicalClinicProxyException {
    public DateNullException(String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }
}
