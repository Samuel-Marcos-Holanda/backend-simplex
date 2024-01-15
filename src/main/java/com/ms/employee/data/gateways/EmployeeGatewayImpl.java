package com.ms.employee.data.gateways;

import java.util.ArrayList;
import java.util.List;

import com.ms.employee.core.domain.Employee;
import com.ms.employee.core.gateways.EmployeeGateways;
import com.ms.employee.data.entity.EmployeeEntity;
import com.ms.employee.data.mappers.EmployeeMapper;
import com.ms.employee.data.repositories.EmployeeRepository;

public class EmployeeGatewayImpl implements EmployeeGateways{

    private EmployeeRepository repository;
    private EmployeeMapper mapper;

    public EmployeeGatewayImpl(EmployeeRepository repository, EmployeeMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Employee createEmployee(Employee employee) {
        EmployeeEntity employeeEntity = mapper.toEntity(employee);
        return mapper.toDomain(repository.save(employeeEntity));
    }

    @Override
    public Employee editEmployee(Employee employee) {
        EmployeeEntity employeeEntity = mapper.toEntity(employee);
        return mapper.toDomain(repository.save(employeeEntity));
    }

    @Override
    public boolean removeEmployee(Employee employee) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeEmployee'");
    }

    @Override
    public Employee getById(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public Employee getByCpf(Long cpf) {
        EmployeeEntity employee = repository.findByCpf(cpf);
        if (employee == null) return null;
        return mapper.toDomain(employee);
    }

    @Override
    public List<Employee> getAll() {
        List<Employee> listEmp = new ArrayList<>();
        List<EmployeeEntity> temp = repository.findAll();
        for(EmployeeEntity entity : temp)
        {
            listEmp.add(mapper.toDomain(entity));
        }
        return listEmp;
    }
    
}
