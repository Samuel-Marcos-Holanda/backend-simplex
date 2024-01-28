package com.ms.employee.core.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Benefit {
    String name;
    String description;
    float value;
}
