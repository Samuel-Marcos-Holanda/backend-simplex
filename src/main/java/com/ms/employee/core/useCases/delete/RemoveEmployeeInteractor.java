package com.ms.employee.core.useCases.delete;

import com.ms.employee.core.exceptions.notFound.EmployeeNotFoundException;
import com.ms.employee.core.gateways.EmployeeGateways;
import com.ms.employee.core.useCases.BaseEmployeeInteractor;

public class RemoveEmployeeInteractor extends BaseEmployeeInteractor {

    public RemoveEmployeeInteractor(EmployeeGateways gateway) {
        super(gateway);
    }
    
    public boolean execute(String id) throws EmployeeNotFoundException {
        if (gateway.getById(id) == null) throw new EmployeeNotFoundException();
        return gateway.removeEmployee(id);
    }
}
