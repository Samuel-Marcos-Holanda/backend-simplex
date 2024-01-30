package com.ms.employee.core.DTO.response;

import com.ms.employee.core.domain.Benefit;
import com.ms.employee.core.domain.Employee;
import com.ms.employee.core.domain.Role;

public record EmployeeResponseDTO(String id, Long cpf, String name, String email, String password, Benefit[] benefits,
 String employerId, Float salary, Role role) {
    public EmployeeResponseDTO(Employee employee){
        this(employee.getId(), employee.getCpf(), employee.getName(), employee.getEmail(), employee.getPassword(), employee.getBenefits(),
        employee.getEmployerId(), employee.getSalary(), employee.getRole());
    }
}
