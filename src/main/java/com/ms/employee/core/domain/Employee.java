package com.ms.employee.core.domain;

import com.ms.employee.core.DTO.EmployeeDTO;

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
    private Integer salary;
    private String role;

    public Employee(Long cpf, String name, Integer salary, String role) {
        this.cpf = cpf;
        this.name = name;
        this.salary = salary;
        this.role = role;
    }

    public Employee(EmployeeDTO cEmployeeDTO) {
        this.cpf = cEmployeeDTO.cpf();
        this.name = cEmployeeDTO.name();
        this.salary = cEmployeeDTO.salary();
        this.role = cEmployeeDTO.role();
    }
}