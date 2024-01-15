package com.ms.employee.infra.controllers;

import java.util.List;

import com.ms.employee.core.useCases.GetAllEmployeesInteractor;
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
import com.ms.employee.core.useCases.GetEmployeeInteractor;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final CreateEmployeeInteractor createInteractor;
    // private final EditEmployeeInteractor editInteractor;
    private final GetEmployeeInteractor getInteractor;
    private final GetAllEmployeesInteractor getAllEmployeesInteractor;
    
    public EmployeeController(CreateEmployeeInteractor createInteractor, GetEmployeeInteractor getInteractor, GetAllEmployeesInteractor getAllEmployeesInteractor) {
        this.createInteractor = createInteractor;
        this.getInteractor = getInteractor;
        // this.editInteractor = editInteractor;
        this.getAllEmployeesInteractor = getAllEmployeesInteractor;
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() throws Exception
    {
        List<Employee> listEmp = getAllEmployeesInteractor.execute();
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
    
    // @Transactional
    // @PutMapping
    // public ResponseEntity<Employee> editEmployee(@RequestBody EmployeeDTO employeeDTO) throws Exception
    // {
    //     Employee emp = editInteractor.execute(employeeDTO);
    //     return new ResponseEntity<>(emp, HttpStatus.CREATED);
    // }
}
