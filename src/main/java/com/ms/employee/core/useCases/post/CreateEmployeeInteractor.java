package com.ms.employee.core.useCases.post;

import com.ms.employee.core.DTO.request.EmployeeRequestDTO;
import com.ms.employee.core.DTO.response.EmployeeResponseDTO;
import com.ms.employee.core.domain.Employee;
import com.ms.employee.core.exceptions.alreadyRegistered.AlreadyRegisteredCpfException;
import com.ms.employee.core.exceptions.alreadyRegistered.AlreadyRegisteredEmailException;
import com.ms.employee.core.exceptions.others.InvalidEmailFormatException;
import com.ms.employee.core.gateways.EmployeeGateways;
import com.ms.employee.core.useCases.BaseEmployeeInteractor;

public class CreateEmployeeInteractor extends BaseEmployeeInteractor {
    public CreateEmployeeInteractor(EmployeeGateways gateway) {
        super(gateway);
    }

    public EmployeeResponseDTO execute(EmployeeRequestDTO employeeDTO) throws Exception
    {
        Employee toCreateEmployee = new Employee(employeeDTO);
        if(!toCreateEmployee.getEmail().contains("@")) throw new InvalidEmailFormatException();
        if (gateway.getByCpf(toCreateEmployee.getCpf()) != null) throw new AlreadyRegisteredCpfException();
        if (gateway.getByEmail(toCreateEmployee.getEmail()) != null) throw new AlreadyRegisteredEmailException();
        return new EmployeeResponseDTO(gateway.createEmployee(toCreateEmployee));
    }
}
