package com.ms.employee.infra.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.employee.core.DTO.EmployeeDTO;
import com.ms.employee.core.domain.Employee;
import com.ms.employee.core.useCases.CreateEmployeeInteractor;
import com.ms.employee.core.useCases.EditEmployeeInteractor;
import com.ms.employee.core.useCases.GetEmployeeInteractor;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private CreateEmployeeInteractor createInteractor;
    private EditEmployeeInteractor editInteractor;
    private GetEmployeeInteractor getInteractor;
    
    public EmployeeController(CreateEmployeeInteractor createInteractor, GetEmployeeInteractor getInteractor) {
        this.createInteractor = createInteractor;
        this.getInteractor = getInteractor;
    }

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody EmployeeDTO employeeDTO) throws Exception
    {
        Employee emp = createInteractor.execute(employeeDTO);
        return new ResponseEntity<>(emp, HttpStatus.CREATED); 
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() throws Exception
    {
        List<Employee> listEmp = getInteractor.execute();
        return new ResponseEntity<>(listEmp, HttpStatus.OK);
    }

    @GetMapping("/{employeeCpf}")
    public ResponseEntity<Employee> getEmployee(@PathVariable(value = "employeeCpf") Long employeeCpf) throws Exception {
        Employee emp = getInteractor.execute(employeeCpf);
        return new ResponseEntity<>(emp, HttpStatus.OK);
    }
    
    // @PutMapping
    // @Transactional
    // public ResponseEntity<Employee> editEmployee(@RequestBody EmployeeDTO employeeDTO) throws Exception 
    // {
    //     Employee emp = editInteractor.execute(employeeDTO);
    //     return new ResponseEntity<>(emp, HttpStatus.CREATED);
    // }
}
