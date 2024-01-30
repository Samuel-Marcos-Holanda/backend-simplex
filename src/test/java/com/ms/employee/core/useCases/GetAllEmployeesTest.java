package com.ms.employee.core.useCases;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.ms.employee.core.useCases.get.GetAllEmployeesInteractor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.ms.employee.core.DTO.response.EmployeeResponseDTO;
import com.ms.employee.core.domain.Benefit;
import com.ms.employee.core.domain.Employee;
import com.ms.employee.core.domain.Role;
import com.ms.employee.core.exceptions.notFound.EmployeeNotFoundException;
import com.ms.employee.core.gateways.EmployeeGateways;

public class GetAllEmployeesTest {
    @InjectMocks
    private GetAllEmployeesInteractor interactor;
    
    @Mock
    private EmployeeGateways gateway;

    @BeforeEach
    public void init()
    {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void sucessfullyGetAll() throws EmployeeNotFoundException {
        Benefit[] benefits = new Benefit[] {
            new Benefit("vale-alimentação", "pra encher o buxo", 600f), 
            new Benefit("gympass", "p maiá os cambito", 100f),
        };

        ArrayList<Employee> expectedConstructor = new ArrayList<>();
        expectedConstructor.add(new Employee("aaaa-aaaa-aaaa-aaaa", 12345678900l, "Samuel",
        1200f, "samukaboydoido@gmail.com",  "1234pwd", benefits, "aaaa-aaaa-aaaa-aaa", Role.COMMON));

        expectedConstructor.add(new Employee("bbbb-bbb-bbbb-bbbb", 12344124l, "Arthur",
        1400f, "aarthur@gmail.com",  "1234pwd", benefits, "bbbb-bbbb-bbb-bbb", Role.ROOT));

        List<EmployeeResponseDTO> expectedReturn = expectedConstructor.stream().map(EmployeeResponseDTO::new).toList();

        when(gateway.getAll()).thenReturn(expectedConstructor);

        assertEquals(expectedReturn, interactor.execute());
    }

    @Test
    public void noEmployeeFound() throws EmployeeNotFoundException {
        ArrayList<Employee> expected = new ArrayList<>();
        when(gateway.getAll()).thenReturn(expected);

        assertThrows(EmployeeNotFoundException.class, () -> interactor.execute());
    }
}
