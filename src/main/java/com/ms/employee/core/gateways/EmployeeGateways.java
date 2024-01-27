package com.ms.employee.core.gateways;

import java.util.List;

import com.ms.employee.core.DTO.EmployeeRequestDTO;
import com.ms.employee.core.domain.Employee;

public interface EmployeeGateways {
    public Employee createEmployee(Employee employee);
    public Employee updateEmployee(Long cpfToEdit, EmployeeRequestDTO employeeDTO);
    public boolean removeEmployee(Employee employee);
    public Employee getById(String id);
    public Employee getByCpf(Long cpf);
    public Employee getByEmail(String email);
    public List<Employee> getAll();
}
