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

import com.ms.employee.core.gateways.EmployeeGateways;

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

}
