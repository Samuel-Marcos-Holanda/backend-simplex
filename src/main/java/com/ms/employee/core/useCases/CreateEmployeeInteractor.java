package com.ms.employee.core.useCases;

import com.ms.employee.core.DTO.EmployeeDTO;
import com.ms.employee.core.domain.Employee;
import com.ms.employee.core.exceptions.alreadyRegistered.AlreadyRegisteredCpfException;
import com.ms.employee.core.exceptions.alreadyRegistered.AlreadyRegisteredEmailException;
import com.ms.employee.core.gateways.EmployeeGateways;

public class CreateEmployeeInteractor extends BaseEmployeeInteractor {
    public CreateEmployeeInteractor(EmployeeGateways gateway) {
        super(gateway);
    }

    public Employee execute(EmployeeDTO employeeDTO) throws Exception
    {

        System.out.println(employeeDTO.email());
        Employee toCreateEmployee = new Employee(employeeDTO);

        if (gateway.getByCpf(toCreateEmployee.getCpf()) != null) throw new AlreadyRegisteredCpfException();
        if (gateway.getByEmail(toCreateEmployee.getEmail()) != null) throw new AlreadyRegisteredEmailException();
        return gateway.createEmployee(toCreateEmployee);
    }
}