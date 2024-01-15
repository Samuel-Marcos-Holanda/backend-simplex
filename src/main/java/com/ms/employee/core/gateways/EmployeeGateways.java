package com.ms.employee.core.gateways;

import com.ms.employee.core.domain.Employee;

public interface EmployeeGateways {
    public Employee createEmployee(Employee employee);
    public Employee editEmployee(Employee employee);
    public boolean removeEmployee(Employee employee);
    public Employee getById(String id);
    public Employee getByCpf(Long cpf);
}
