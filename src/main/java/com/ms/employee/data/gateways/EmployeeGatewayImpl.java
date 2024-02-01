package com.ms.employee.data.gateways;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.transaction.annotation.Transactional;

import com.mongodb.lang.NonNull;
import com.ms.employee.core.DTO.request.EmployeeRequestDTO;
import com.ms.employee.core.domain.Employee;
import com.ms.employee.core.exceptions.notFound.EmployeeNotFoundException;
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

    @Transactional
    @Override
    public Employee updateEmployee(String id, @NonNull EmployeeRequestDTO employeeDTO) throws EmployeeNotFoundException {
        if (employeeDTO == null || id == null) {
            return null;
        }
        EmployeeEntity employee = repository.findById(id).get();
		if(employee == null) {
			throw new EmployeeNotFoundException();
		}
		BeanUtils.copyProperties(employeeDTO, employee);
        repository.save(employee);
        return mapper.toDomain(employee);
    }

    @Override
    public boolean removeEmployee(String id) {
        repository.deleteById(id);
        return true;
    }

    @Override
    public Employee getById(String id) throws EmployeeNotFoundException {
        Optional<EmployeeEntity> empOptional = repository.findById(id);
        if (empOptional.isEmpty()) throw new EmployeeNotFoundException();
        return mapper.toDomain(empOptional.get());
    }

    @Override
    public Employee getByCpf(Long cpf) {
        EmployeeEntity employee = repository.findByCpf(cpf);
        if (employee == null) return null;
        return mapper.toDomain(employee);
    }

    @Override
    public Employee getByEmail(String email) {
        Optional<EmployeeEntity> employeeOptional = repository.findByEmail(email);
        if(employeeOptional.isEmpty()) return null;
        return mapper.toDomain(employeeOptional.get());
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
