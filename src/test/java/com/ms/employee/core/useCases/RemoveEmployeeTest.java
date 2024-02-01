package com.ms.employee.core.useCases;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.ms.employee.core.domain.Benefit;
import com.ms.employee.core.domain.Employee;
import com.ms.employee.core.domain.Role;
import com.ms.employee.core.exceptions.notFound.EmployeeNotFoundException;
import com.ms.employee.core.gateways.EmployeeGateways;
import com.ms.employee.core.useCases.delete.RemoveEmployeeInteractor;

public class RemoveEmployeeTest {
    @InjectMocks
    private RemoveEmployeeInteractor interactor;
    
    @Mock
    private EmployeeGateways gateway;

    @BeforeEach
    public void init()
    {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void sucessfullyDeleteEmployee() throws Exception {
        String id = "aaaa-aaaa-aaaa-aaaa";

        Benefit[] benefits = new Benefit[] {
            new Benefit("vale-alimentação", "pra enxer o buxo", 600)
        };
        Employee returnedEmployee = new Employee(id, 123456l, "Arthur", 3000f, "aarthurian@gmail.com", 
        "123pwd", benefits, "aabbab-abab-abab-abab", Role.COMMON);

        when(gateway.getById(id)).thenReturn(returnedEmployee);
        when(gateway.removeEmployee(id)).thenReturn(true);
        assertEquals(true, interactor.execute(id));
    }

    @Test
    public void employeeNotFoundDeleteEmployee() throws Exception {
        String id = "aaaa-aaaa-aaaa-aaaa";
        when(gateway.getById(id)).thenReturn(null);
        assertThrows(EmployeeNotFoundException.class, () -> interactor.execute(id));
    }
}
