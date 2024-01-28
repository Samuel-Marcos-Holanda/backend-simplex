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

import com.ms.employee.core.DTO.EmployeeRequestDTO;
import com.ms.employee.core.DTO.EmployeeResponseDTO;
import com.ms.employee.core.domain.Benefit;
import com.ms.employee.core.domain.Employee;
import com.ms.employee.core.exceptions.alreadyRegistered.AlreadyRegisteredCpfException;
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
        Benefit[] benefits = new Benefit[] {new Benefit("vale-alimentação", "pra encher o buxo", 600f)};
        EmployeeRequestDTO employeeRequestDTO = new EmployeeRequestDTO(12345678900l, "Samuel", "samukaboydoido@gmail.com", 
        "1234pwd", benefits, "aaaa-aaaa-aaaa-aaa", 1200f, "common");

        Employee toCreate = new Employee(employeeRequestDTO);
        when(gateway.getByCpf(toCreate.getCpf())).thenReturn(null);
        when(gateway.createEmployee(any(Employee.class))).thenReturn(toCreate);

        EmployeeResponseDTO expected = new EmployeeResponseDTO(toCreate);
        assertEquals(expected, interactor.execute(employeeRequestDTO));
    }

    @Test
    public void createEmployeeWithSameCpf() throws Exception {
        Benefit[] benefits = new Benefit[] {new Benefit("vale-alimentação", "pra encher o buxo", 600f)};
        EmployeeRequestDTO employeeRequestDTO = new EmployeeRequestDTO(12345678900l, "Samuel", "samukaboydoido@gmail.com", 
        "1234pwd", benefits, "aaaa-aaaa-aaaa-aaa", 1200f, "common");    

        Employee expected = new Employee(employeeRequestDTO);
        when(gateway.getByCpf(expected.getCpf())).thenReturn(expected);

        assertThrows(AlreadyRegisteredCpfException.class, () -> interactor.execute(employeeRequestDTO));
    }
}
