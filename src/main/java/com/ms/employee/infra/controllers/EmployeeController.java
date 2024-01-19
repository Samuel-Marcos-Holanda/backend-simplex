package com.ms.employee.infra.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.ms.employee.core.useCases.GetAllEmployeesInteractor;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.employee.core.DTO.EmployeeDTO;
import com.ms.employee.core.domain.Employee;
import com.ms.employee.core.useCases.CreateEmployeeInteractor;
import com.ms.employee.core.useCases.GetEmployeeInteractor;
import com.ms.employee.core.useCases.UpdateEmployeeInteractor;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final CreateEmployeeInteractor createInteractor;
    private final UpdateEmployeeInteractor updateInteractor;
    private final GetEmployeeInteractor getInteractor;
    private final GetAllEmployeesInteractor getAllInteractor;
    
    public EmployeeController(
            CreateEmployeeInteractor createInteractor, 
            GetEmployeeInteractor getInteractor, 
            GetAllEmployeesInteractor getAllInteractor, 
            UpdateEmployeeInteractor updateInteractor) {
        this.createInteractor = createInteractor;
        this.getInteractor = getInteractor;
        this.updateInteractor = updateInteractor;
        this.getAllInteractor = getAllInteractor;
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() throws Exception
    {
        List<Employee> listEmp = getAllInteractor.execute();
        return new ResponseEntity<>(listEmp, HttpStatus.OK);
    }

    @GetMapping("/{employeeCpf}")
    public ResponseEntity<Employee> getEmployee(@PathVariable(value = "employeeCpf") Long employeeCpf) throws Exception {
        Employee emp = getInteractor.execute(employeeCpf);
        return new ResponseEntity<>(emp, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody EmployeeDTO employeeDTO) throws Exception
    {
        Employee emp = createInteractor.execute(employeeDTO);
        return new ResponseEntity<>(emp, HttpStatus.CREATED);
    }
    
    @PutMapping("/{cpf}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value="cpf") Long cpf, @RequestBody EmployeeDTO employeeDTO) throws Exception {
        Employee emp = updateInteractor.execute(cpf, employeeDTO);
        return new ResponseEntity<>(emp, HttpStatus.OK);
	}
}
