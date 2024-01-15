package com.ms.employee.core.useCases;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
import com.ms.employee.core.gateways.EmployeeGateways;

public class EditEmployeeTest {
    @InjectMocks
    private EditEmployeeInteractor interactor;
    
    @Mock
    private EmployeeGateways gateway;

    @BeforeEach
    public void init()
    {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void createEmployeeSuccess() throws Exception
    {   EmployeeDTO employeeDTO = new EmployeeDTO(123456789, "Samuel", 130000, "Limpador De Pizo Kkk");
        Employee toEdit = new Employee(employeeDTO);
        when(gateway.getByCpf(anyLong())).thenReturn(any(Employee.class));
        when(gateway.createEmployee(toEdit)).thenReturn(toEdit);    

        assertEquals(toEdit, interactor.execute(employeeDTO)); 
    }
}
