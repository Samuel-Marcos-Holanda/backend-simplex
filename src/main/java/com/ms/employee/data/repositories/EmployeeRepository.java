package com.ms.employee.data.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mongodb.lang.NonNull;
import com.ms.employee.data.entity.EmployeeEntity;

public interface EmployeeRepository extends MongoRepository<EmployeeEntity, String> {
    public EmployeeEntity findByCpf(Long cpf);
    public Optional<EmployeeEntity> findById(@NonNull String id);
}