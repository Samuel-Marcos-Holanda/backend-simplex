package com.ms.employee.core.domain;

public enum Role {
    ROOT("root"),
    COMMON("common");

    final String role;

    Role(String role){
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
