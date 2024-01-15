package com.ms.employee.infra.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.employee.core.DTO.EmployeeDTO;
import com.ms.employee.core.domain.Employee;
import com.ms.employee.core.useCases.CreateEmployeeInteractor;
import com.ms.employee.core.useCases.EditEmployeeInteractor;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private CreateEmployeeInteractor createInteractor;
    private EditEmployeeInteractor editInteractor;

    public EmployeeController(CreateEmployeeInteractor interactor) {
        this.createInteractor = interactor;
    }

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody EmployeeDTO employeeDTO) throws Exception
    {
        Employee emp = createInteractor.execute(employeeDTO);
        return new ResponseEntity<>(emp, HttpStatus.CREATED); 
    }
    
    // @PutMapping
    // @Transactional
    // public ResponseEntity<Employee> editEmployee(@RequestBody EmployeeDTO employeeDTO) throws Exception 
    // {
    //     Employee emp = editInteractor.execute(employeeDTO);
    //     return new ResponseEntity<>(emp, HttpStatus.CREATED);
    // }
}
