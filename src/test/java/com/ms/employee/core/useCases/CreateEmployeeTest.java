package com.ms.employee.core.useCases;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.ms.employee.core.DTO.EmployeeDTO;
import com.ms.employee.core.domain.Employee;
import com.ms.employee.core.exceptions.AlreadyRegisteredCpf;
import com.ms.employee.core.gateways.EmployeeGateways;

public class CreateEmployeeTest {
    @InjectMocks
    private CreateEmployeeInteractor interactor;
    
    @Mock
    private EmployeeGateways gateway;

    @BeforeEach
    public void init()
    {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void createEmployeeSuccess() throws Exception {
        EmployeeDTO employeeDTO = new EmployeeDTO(123456789, "Samuel", 130000, "Limpador De Pizo Kkk");
        Employee toCreate = new Employee(employeeDTO);
        when(gateway.getByCpf(anyLong())).thenReturn(null);
        when(gateway.createEmployee(any(Employee.class))).thenReturn(toCreate);
        
        assertEquals(toCreate, interactor.execute(employeeDTO));
    }

    @Test
    public void createEmployeeWithSameCpf() throws Exception {
        EmployeeDTO employeeDTO = new EmployeeDTO(123456789, "Samuel", 130000, "Limpador De Pizo Kkk");
        Employee expected = new Employee(employeeDTO);
        when(gateway.getByCpf(anyLong())).thenReturn(expected);

        assertThrows(AlreadyRegisteredCpf.class, () -> interactor.execute(employeeDTO));
    }
}
