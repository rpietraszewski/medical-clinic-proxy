package com.rpietraszewski.medicalclinicproxy.exception;

import org.springframework.http.HttpStatus;

public class AssignVisitNullFieldsException extends MedicalClinicProxyException{
    public AssignVisitNullFieldsException(String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }
}