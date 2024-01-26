package com.ms.employee.data.gateways;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.transaction.annotation.Transactional;

import com.mongodb.lang.NonNull;
import com.ms.employee.core.DTO.EmployeeDTO;
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

    @Transactional
    @Override
    public Employee updateEmployee(Long cpfToEdit, @NonNull EmployeeDTO employeeDTO) {
        if (employeeDTO == null || cpfToEdit == null) {
            return null;
        }
        EmployeeEntity employee = repository.findByCpf(cpfToEdit);
		if(employee == null) {
			return null;
		}
		BeanUtils.copyProperties(employeeDTO, employee);
        repository.save(employee);
        return mapper.toDomain(employee);
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