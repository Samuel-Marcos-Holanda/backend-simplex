package com.ms.employee.data.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ms.employee.data.entity.EmployeeEntity;

public interface EmployeeRepository extends MongoRepository<EmployeeEntity, String> {
    public EmployeeEntity findByCpf(Long cpf);
}