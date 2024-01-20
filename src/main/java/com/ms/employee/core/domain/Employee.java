package com.ms.employee.core.domain;

import com.ms.employee.core.DTO.EmployeeDTO;

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
    private String email;
    private Integer salary;
    private Role role;

    public Employee(Long cpf, String name, String email, Integer salary, Role role) throws InvalidEmailFormatException {
        this.cpf = cpf;
        this.name = name;
        this.salary = salary;
        this.role = role;

        if(!email.contains("@")) throw new InvalidEmailFormatException();
        this.email = email;
    }

    public Employee(EmployeeDTO cEmployeeDTO) throws InvalidEmailFormatException {
        this.cpf = cEmployeeDTO.cpf();
        this.name = cEmployeeDTO.name();
        this.salary = cEmployeeDTO.salary();
        this.role = Role.valueOf(cEmployeeDTO.role().toUpperCase());
        this.email = cEmployeeDTO.email();
        if(!email.contains("@")) throw new InvalidEmailFormatException();
    }
}