package com.ms.employee.core.useCases;

import com.ms.employee.core.DTO.EmployeeDTO;
import com.ms.employee.core.domain.Employee;
import com.ms.employee.core.gateways.EmployeeGateways;

public class RemoveEmployeeInteractor extends BaseEmployeeInteractor{

    public RemoveEmployeeInteractor(EmployeeGateways gateway) {
        super(gateway);
    }
    
    public boolean execute(EmployeeDTO employeeDTO)
    {
        Employee emp = new Employee(employeeDTO);
        if (gateway.getByCpf(emp.getCpf()) == null) return false;
        return gateway.removeEmployee(emp);
    }
}
