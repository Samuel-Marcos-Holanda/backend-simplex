package com.ms.employee.infra.main;

import com.ms.employee.core.useCases.delete.RemoveEmployeeInteractor;
import com.ms.employee.core.useCases.get.GetAllEmployeesInteractor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ms.employee.core.gateways.EmployeeGateways;
import com.ms.employee.core.useCases.post.CreateEmployeeInteractor;
import com.ms.employee.core.useCases.get.GetEmployeeInteractor;
import com.ms.employee.core.useCases.put.UpdateEmployeeInteractor;
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
    UpdateEmployeeInteractor updateEmployeeInteractor(EmployeeGateways gateway)
    {
        return new UpdateEmployeeInteractor(gateway);
    }

    @Bean
    GetEmployeeInteractor getEmployeeInteractor(EmployeeGateways gateway) {
        return new GetEmployeeInteractor(gateway);
    }

    @Bean
    GetAllEmployeesInteractor getAllEmployeesInteractor(EmployeeGateways gateway) {
        return new GetAllEmployeesInteractor(gateway);
    }

    @Bean
    RemoveEmployeeInteractor deleteEmployeeInteractor(EmployeeGateways gateway) {
        return new RemoveEmployeeInteractor(gateway);
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
