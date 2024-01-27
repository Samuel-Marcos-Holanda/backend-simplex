package com.ms.employee.core.domain;

import com.ms.employee.core.DTO.EmployeeRequestDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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

    public Employee(String id, Long cpf, String name, Float salary, String email, String password, Benefit[] benefits,
            String employerId, Role role) {
        this.id = id;
        this.cpf = cpf;
        this.name = name;
        this.salary = salary;
        this.email = email;
        this.password = password;
        this.benefits = benefits;
        this.employerId = employerId;
        this.role = role;
    }

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