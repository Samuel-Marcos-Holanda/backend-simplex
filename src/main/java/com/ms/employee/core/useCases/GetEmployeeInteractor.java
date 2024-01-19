package com.ms.employee.core.useCases;

import com.ms.employee.core.domain.Employee;
import com.ms.employee.core.exceptions.EmployeeNotFoundException;
import com.ms.employee.core.gateways.EmployeeGateways;

public class GetEmployeeInteractor extends BaseEmployeeInteractor{

    public GetEmployeeInteractor(EmployeeGateways gateway) {
        super(gateway);
    }

    public Employee execute(Long cpf) throws EmployeeNotFoundException
    {
        Employee emp = gateway.getByCpf(cpf);
        if (emp == null) throw new EmployeeNotFoundException();
        return emp;
    }
}
