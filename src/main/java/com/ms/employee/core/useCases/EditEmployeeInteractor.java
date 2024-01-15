package com.ms.employee.core.useCases;

import com.ms.employee.core.DTO.EmployeeDTO;
import com.ms.employee.core.domain.Employee;
import com.ms.employee.core.gateways.EmployeeGateways;

public class EditEmployeeInteractor extends BaseEmployeeInteractor {

    public EditEmployeeInteractor(EmployeeGateways gateway) {
        super(gateway);
    }
    
    public Employee execute(EmployeeDTO employeeDTO) throws Exception
    {
        Employee editedEmployee = new Employee(employeeDTO);
        return gateway.editEmployee(editedEmployee);
    }
}
