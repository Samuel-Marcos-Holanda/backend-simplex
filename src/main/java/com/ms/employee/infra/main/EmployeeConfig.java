package com.ms.employee.infra.main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ms.employee.core.gateways.EmployeeGateways;
import com.ms.employee.core.useCases.CreateEmployeeInteractor;
import com.ms.employee.core.useCases.GetEmployeeInteractor;
import com.ms.employee.data.gateways.EmployeeGatewayImpl;
import com.ms.employee.data.mappers.EmployeeMapper;
import com.ms.employee.data.repositories.EmployeeRepository;

@Configuration
public class EmployeeConfig {

    @Bean
    CreateEmployeeInteractor createEmployeeInteractor(EmployeeGateways gateway)
    {
        return new CreateEmployeeInteractor(gateway);
    }

    @Bean
    GetEmployeeInteractor getEmployeeInteractor(EmployeeGateways gateway) {
        return new GetEmployeeInteractor(gateway);
    }

    @Bean
    EmployeeGateways employeeGateways(EmployeeRepository repository, EmployeeMapper mapper)
    {
        return new EmployeeGatewayImpl(repository, mapper);
    }

    @Bean
    EmployeeMapper employeeMapper()
    {
        return new EmployeeMapper();
    }
}
