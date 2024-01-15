package com.ms.employee.data.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.ms.employee.core.DTO.EmployeeDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Document(collection = "employee")
public class EmployeeEntity {
    @Id
    private String id;
    private Long cpf;
    private String name;
    private Integer salary;
    private String role;
    
    public EmployeeEntity() {
    }

    public EmployeeEntity(Long cpf, String name, Integer salary, String role) {
        this.cpf = cpf;
        this.name = name;
        this.salary = salary;
        this.role = role;
    }

    public EmployeeEntity(EmployeeDTO cEmployeeDTO) {
        this.cpf = cEmployeeDTO.cpf();
        this.name = cEmployeeDTO.name();
        this.salary = cEmployeeDTO.salary();
        this.role = cEmployeeDTO.role();
    }
}
