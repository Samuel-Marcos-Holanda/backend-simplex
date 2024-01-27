package com.ms.employee.data.mappers;

import com.ms.employee.core.domain.Employee;
import com.ms.employee.data.entity.EmployeeEntity;

public class EmployeeMapper {
    public Employee toDomain(EmployeeEntity employee)
    {
        return new Employee(employee.getId(), employee.getCpf(), employee.getName(), employee.getSalary(),
                employee.getEmail(), employee.getPassword(), employee.getBenefits(), employee.getEmployerId(),
                employee.getRole());
    }
    public EmployeeEntity toEntity(Employee employee)
    {
        return new EmployeeEntity(employee.getCpf(), employee.getName(), employee.getEmail(), employee.getPassword(),
                employee.getBenefits(), employee.getEmployerId(), employee.getSalary(), employee.getRole());
    }
}
