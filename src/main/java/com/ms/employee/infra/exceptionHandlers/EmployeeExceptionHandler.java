package com.ms.employee.infra.exceptionHandlers;

import com.ms.employee.core.DTO.ExceptionDTO;
import com.ms.employee.core.exceptions.EmployeeNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeExceptionHandler {

    @ExceptionHandler(EmployeeNotFound.class)
    public ResponseEntity<ExceptionDTO> employeeNotFound(){
        return new ResponseEntity<>(new ExceptionDTO("Não foi encontrado nenhum funcionário."), HttpStatus.NOT_FOUND);
    }

}
