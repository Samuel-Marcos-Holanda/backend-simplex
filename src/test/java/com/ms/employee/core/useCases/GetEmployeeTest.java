package com.ms.employee.core.useCases;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import com.ms.employee.core.useCases.get.GetEmployeeInteractor;
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

public class GetEmployeeTest {
    @InjectMocks
    private GetEmployeeInteractor interactor;
    
    @Mock
    private EmployeeGateways gateway;

    @BeforeEach
    public void init()
    {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void sucessfullyGetEmployee() throws EmployeeNotFoundException {
        Benefit[] benefits = new Benefit[] {
            new Benefit("vale-alimentação", "pra enxer o buxo", 600)
        };

        Employee expected = new Employee("aaaa-aaaa-aaaa-aaaa", 123456l, "Arthur", 3000f, "aarthurian@gmail.com", "123pwd", benefits, 
        "aabbab-abab-abab-abab", Role.COMMON);

        when(gateway.getById(expected.getId())).thenReturn(expected);

        assertEquals(expected, interactor.execute("aaaa-aaaa-aaaa-aaaa"));
    }

    @Test
    public void notFoundGetEmployee() throws EmployeeNotFoundException {
        when(gateway.getById(anyString())).thenReturn(null);

        assertThrows(EmployeeNotFoundException.class, () -> interactor.execute("aaa-aaaa-aaaa-aaaa"));
    }
}
