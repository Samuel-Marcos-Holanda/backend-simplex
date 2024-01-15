package com.ms.employee.core.useCases;

import java.util.List;

import com.ms.employee.core.domain.Employee;
import com.ms.employee.core.exceptions.EmployeeNotFound;
import com.ms.employee.core.gateways.EmployeeGateways;

public class GetEmployeeInteractor extends BaseEmployeeInteractor{

    public GetEmployeeInteractor(EmployeeGateways gateway) {
        super(gateway);
    }
    /**
     * 
     * @param cpf a Long object used to find the employee in the database
     * @return
     * @throws EmployeeNotFound
     */
    public Employee execute(Long cpf) throws EmployeeNotFound
    {
        Employee emp = gateway.getByCpf(cpf);
        if (emp == null) throw new EmployeeNotFound();
        return emp;
    }
    public List<Employee> execute() throws EmployeeNotFound 
    {
        List<Employee> listEmp = gateway.getAll();
        if (listEmp == null || listEmp.isEmpty()) throw new EmployeeNotFound();
        return listEmp;
    }
}
