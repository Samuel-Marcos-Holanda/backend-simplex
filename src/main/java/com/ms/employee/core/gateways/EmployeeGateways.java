package com.ms.employee.core.gateways;

import java.util.List;

import com.ms.employee.core.DTO.request.EmployeeRequestDTO;
import com.ms.employee.core.domain.Employee;
import com.ms.employee.core.exceptions.notFound.EmployeeNotFoundException;

public interface EmployeeGateways {
    public Employee createEmployee(Employee employee);
    public Employee updateEmployee(String id, EmployeeRequestDTO employeeDTO) throws EmployeeNotFoundException;
    public boolean removeEmployee(String id);
    public Employee getById(String id) throws EmployeeNotFoundException;
    public Employee getByCpf(Long cpf);
    public Employee getByEmail(String email);
    public List<Employee> getAll();
}
