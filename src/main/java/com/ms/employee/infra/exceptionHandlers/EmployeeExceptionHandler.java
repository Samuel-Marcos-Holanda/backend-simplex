package com.ms.employee.infra.exceptionHandlers;

import com.ms.employee.core.DTO.ExceptionDTO;
import com.ms.employee.core.exceptions.alreadyRegistered.AlreadyRegisteredCpfException;
import com.ms.employee.core.exceptions.alreadyRegistered.AlreadyRegisteredEmailException;
import com.ms.employee.core.exceptions.notFound.EmployeeNotFoundException;
import com.ms.employee.core.exceptions.others.BadUpdateException;
import com.ms.employee.core.exceptions.others.InvalidEmailFormatException;
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

    @ExceptionHandler(AlreadyRegisteredEmailException.class)
    public ResponseEntity<ExceptionDTO> alreadyRegisteredEmailException() {
        return new ResponseEntity<>(new ExceptionDTO("Funcionário com esse e-mail já cadastrado no sistema."), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AlreadyRegisteredCpfException.class)
    public ResponseEntity<ExceptionDTO> alreadyRegisteredCpfException() {
        return new ResponseEntity<>(new ExceptionDTO("Funcionário com esse cpf já cadastrado no sistema."), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidEmailFormatException.class)
    public ResponseEntity<ExceptionDTO> invalidEmailFormatException() {
        return new ResponseEntity<>(new ExceptionDTO("Formato de e-mail inválido"), HttpStatus.BAD_REQUEST);
    }
}
