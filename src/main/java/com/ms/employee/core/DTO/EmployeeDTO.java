package com.ms.employee.core.DTO;

import com.ms.employee.core.domain.Benefit;

public record EmployeeDTO(Long cpf, String name, String email, String password, Benefit[] benefits,
 String employerId, Float salary, String role) {}
