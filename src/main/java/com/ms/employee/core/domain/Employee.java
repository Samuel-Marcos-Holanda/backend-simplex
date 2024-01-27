package com.ms.employee.core.domain;

import com.ms.employee.core.DTO.EmployeeRequestDTO;

import com.ms.employee.core.exceptions.others.InvalidEmailFormatException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Employee {
    private String id;
    private Long cpf;
    private String name;
    private Float salary;
    private String email;
    private String password;
    private Benefit[] benefits;
    private String employerId;
    private Role role;

    public Employee(Long cpf, String name, String email, String password, Benefit[] benefits, String employerId, Float salary, Role role) {
        this.cpf = cpf;
        this.name = name;
        this.salary = salary;
        this.role = role;
        this.email = email;
        this.password = password;
        this.benefits = benefits;
        this.employerId = employerId;
    }

    public Employee(EmployeeRequestDTO cEmployeeDTO) {
        this.cpf = cEmployeeDTO.cpf();
        this.name = cEmployeeDTO.name();
        this.salary = cEmployeeDTO.salary();
        this.role = Role.valueOf(cEmployeeDTO.role().toUpperCase());
        this.email = cEmployeeDTO.email();
        this.password = cEmployeeDTO.password();
        this.benefits = cEmployeeDTO.benefits();
        this.employerId = cEmployeeDTO.employerId();
    }
}