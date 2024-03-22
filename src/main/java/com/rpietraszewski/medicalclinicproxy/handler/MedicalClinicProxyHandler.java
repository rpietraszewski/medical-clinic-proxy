package com.rpietraszewski.medicalclinicproxy.handler;

import com.rpietraszewski.medicalclinicproxy.exception.AssignVisitNullFieldsException;
import com.rpietraszewski.medicalclinicproxy.exception.DateNullException;
import com.rpietraszewski.medicalclinicproxy.exception.PatientIdNullException;
import com.rpietraszewski.medicalclinicproxy.exception.PatientNullFieldsException;
import com.rpietraszewski.medicalclinicproxy.model.dto.MessageDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDate;

@RestControllerAdvice
public class MedicalClinicProxyHandler extends ResponseEntityExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(DateNullException.class)
    protected MessageDTO onDateNullErrorHandler(DateNullException ex) {
        return new MessageDTO(ex.getMessage(), LocalDate.now(), ex.getHttpStatus());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(PatientIdNullException.class)
    protected MessageDTO onPatientIdNullErrorHandler(PatientIdNullException ex) {
        return new MessageDTO(ex.getMessage(), LocalDate.now(), ex.getHttpStatus());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(PatientNullFieldsException.class)
    protected MessageDTO onPatientNullFieldsErrorHandler(PatientNullFieldsException ex) {
        return new MessageDTO(ex.getMessage(), LocalDate.now(), ex.getHttpStatus());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(AssignVisitNullFieldsException.class)
    protected MessageDTO onAssignVisitNullFieldsErrorHandler(AssignVisitNullFieldsException ex) {
        return new MessageDTO(ex.getMessage(), LocalDate.now(), ex.getHttpStatus());
    }
}