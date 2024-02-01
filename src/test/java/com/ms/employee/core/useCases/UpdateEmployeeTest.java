package com.ms.employee.core.useCases;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.ms.employee.core.DTO.request.EmployeeRequestDTO;
import com.ms.employee.core.domain.Benefit;
import com.ms.employee.core.domain.Employee;
import com.ms.employee.core.exceptions.notFound.EmployeeNotFoundException;
import com.ms.employee.core.exceptions.others.BadUpdateException;
import com.ms.employee.core.gateways.EmployeeGateways;
import com.ms.employee.core.useCases.put.UpdateEmployeeInteractor;

public class UpdateEmployeeTest {
    @InjectMocks
    private UpdateEmployeeInteractor interactor;
    
    @Mock
    private EmployeeGateways gateway;

    @BeforeEach
    public void init()
    {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void sucessfullyUpdateEmployee() throws Exception {
        EmployeeRequestDTO updateEmployeeDTO = new EmployeeRequestDTO(123456l, "Arthur", "aarthur@hotmail.com", 
        "123pwd", new Benefit[]{new Benefit("vale-alimentação", "p enxer o buxo", 500)}, 
        "bbbb-bbbb-bbbb-bbbb", 1500f, "common");

        Employee expected = new Employee(updateEmployeeDTO);
        expected.setId("aaaa-aaaa-aaaa-aaaa");

        when(gateway.updateEmployee("aaaa-aaaa-aaaa-aaaa", updateEmployeeDTO)).thenReturn(expected);

        assertEquals(expected, interactor.execute("aaaa-aaaa-aaaa-aaaa", updateEmployeeDTO));
    }

    @Test
    public void employeeNotFoundUpdateEmployee() throws Exception {
        EmployeeRequestDTO updateEmployeeDTO = new EmployeeRequestDTO(123456l, "Arthur", "aarthur@hotmail.com", 
        "123pwd", new Benefit[]{new Benefit("vale-alimentação", "p enxer o buxo", 500)}, 
        "bbbb-bbbb-bbbb-bbbb", 1500f, "common");

        when(gateway.updateEmployee("aaaa-aaaa-aaaa-aaaa", updateEmployeeDTO)).thenThrow(EmployeeNotFoundException.class);

        assertThrows(EmployeeNotFoundException.class, () -> interactor.execute("aaaa-aaaa-aaaa-aaaa", updateEmployeeDTO));
    }

    @Test
    public void badUpdateExceptionUpdateEmployee() throws Exception {
        EmployeeRequestDTO updateEmployeeDTO = new EmployeeRequestDTO(123456l, "Arthur", "aarthur@hotmail.com", 
        "123pwd", new Benefit[]{new Benefit("vale-alimentação", "p enxer o buxo", 500)}, 
        "bbbb-bbbb-bbbb-bbbb", 1500f, "common");

        when(gateway.updateEmployee("aaaa-aaaa-aaaa-aaaa", updateEmployeeDTO)).thenReturn(null);

        assertThrows(BadUpdateException.class, () -> interactor.execute("aaaa-aaaa-aaaa-aaaa", updateEmployeeDTO));
    }
}
