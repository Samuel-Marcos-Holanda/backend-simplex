package com.ms.employee.core.useCases;

import com.ms.employee.core.DTO.EmployeeDTO;
import com.ms.employee.core.domain.Employee;
import com.ms.employee.core.exceptions.AlreadyRegisteredCpf;
import com.ms.employee.core.gateways.EmployeeGateways;

public class CreateEmployeeInteractor extends BaseEmployeeInteractor {
    public CreateEmployeeInteractor(EmployeeGateways gateway) {
        super(gateway);
    }

    public Employee execute(EmployeeDTO employeeDTO) throws Exception
    {
        Employee toCreateEmployee = new Employee(employeeDTO);

        if (gateway.getByCpf(toCreateEmployee.getCpf()) != null) throw new AlreadyRegisteredCpf();
        return gateway.createEmployee(toCreateEmployee);
    }
}
