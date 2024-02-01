package com.ms.employee.core.useCases.put;

import com.ms.employee.core.DTO.request.EmployeeRequestDTO;
import com.ms.employee.core.domain.Employee;
import com.ms.employee.core.exceptions.notFound.EmployeeNotFoundException;
import com.ms.employee.core.exceptions.others.BadUpdateException;
import com.ms.employee.core.gateways.EmployeeGateways;
import com.ms.employee.core.useCases.BaseEmployeeInteractor;

public class UpdateEmployeeInteractor extends BaseEmployeeInteractor {

    public UpdateEmployeeInteractor(EmployeeGateways gateway) {
        super(gateway);
    }
    
    public Employee execute(String id, EmployeeRequestDTO employeeDTO) throws BadUpdateException, EmployeeNotFoundException
    {
        Employee emp = gateway.updateEmployee(id, employeeDTO);
        if (emp == null) throw new BadUpdateException();
        return emp;
    }
}
