package com.ms.employee.core.useCases.delete;

import com.ms.employee.core.DTO.request.EmployeeRequestDTO;
import com.ms.employee.core.domain.Employee;
import com.ms.employee.core.exceptions.notFound.EmployeeNotFoundException;
import com.ms.employee.core.exceptions.others.InvalidEmailFormatException;
import com.ms.employee.core.gateways.EmployeeGateways;
import com.ms.employee.core.useCases.BaseEmployeeInteractor;

public class RemoveEmployeeInteractor extends BaseEmployeeInteractor {

    public RemoveEmployeeInteractor(EmployeeGateways gateway) {
        super(gateway);
    }
    
    public boolean execute(EmployeeRequestDTO employeeDTO) throws InvalidEmailFormatException, EmployeeNotFoundException {
        Employee emp = new Employee(employeeDTO);
        if (gateway.getByCpf(emp.getCpf()) == null) return false;
        return gateway.removeEmployee(emp);
    }
}
