package com.ms.employee.data.entity;

import com.ms.employee.core.domain.Benefit;
import com.ms.employee.core.domain.Role;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.ms.employee.core.DTO.EmployeeRequestDTO;

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
    private String email;
    private String password;
    private Benefit[] benefits;
    private String employerId;
    private Float salary;
    private Role role;
    
    public EmployeeEntity() {
    }

    public EmployeeEntity(Long cpf, String name, String email, String password, Benefit[] benefits, String employerId,
     Float salary, Role role) {
        this.cpf = cpf;
        this.name = name;
        this.email = email;
        this.salary = salary;
        this.role = role;
        this.benefits = benefits;
        this.password = password;
        this.employerId = employerId;
    }

    public EmployeeEntity(EmployeeRequestDTO cEmployeeDTO) {
        this.cpf = cEmployeeDTO.cpf();
        this.name = cEmployeeDTO.name();
        this.salary = cEmployeeDTO.salary();
        this.role = Role.valueOf(cEmployeeDTO.role().toUpperCase());
        this.email = cEmployeeDTO.email();
        this.benefits = cEmployeeDTO.benefits();
        this.password = cEmployeeDTO.password();
        this.employerId = cEmployeeDTO.employerId();
    }
}
