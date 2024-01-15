package com.ms.employee.core.useCases;

import com.ms.employee.core.gateways.EmployeeGateways;

public class BaseEmployeeInteractor  {
    protected EmployeeGateways gateway;

    public BaseEmployeeInteractor(EmployeeGateways gateway) {
        this.gateway = gateway;
    }
}
