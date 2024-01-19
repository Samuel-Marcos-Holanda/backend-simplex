package com.ms.employee.infra.exceptionHandlers;

import com.ms.employee.core.DTO.ExceptionDTO;
import com.ms.employee.core.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeExceptionHandler {

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<ExceptionDTO> employeeNotFoundException() {
        return new ResponseEntity<>(new ExceptionDTO("Não foi encontrado nenhum funcionário."), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadUpdateException.class)
    public ResponseEntity<ExceptionDTO> badUpdateException() {
        return new ResponseEntity<>(new ExceptionDTO("Tentativa de atualização falha."), HttpStatus.NOT_FOUND);
    }

}
