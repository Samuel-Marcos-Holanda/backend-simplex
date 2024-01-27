package com.ms.employee.core.useCases;

import com.ms.employee.core.DTO.EmployeeResponseDTO;
import com.ms.employee.core.domain.Employee;
import com.ms.employee.core.exceptions.notFound.EmployeeNotFoundException;
import com.ms.employee.core.gateways.EmployeeGateways;

import java.util.List;

public class GetAllEmployeesInteractor extends BaseEmployeeInteractor{
    public GetAllEmployeesInteractor(EmployeeGateways gateway) {
        super(gateway);
    }

    public List<EmployeeResponseDTO> execute() throws EmployeeNotFoundException
    {
        List<Employee> listEmp = gateway.getAll();
        if (listEmp == null || listEmp.isEmpty()) throw new EmployeeNotFoundException();
        return listEmp.stream().map(EmployeeResponseDTO::new).toList();
    }
}
