package com.lombard.converters;

import com.lombard.dtos.AdminDto;
import com.lombard.entities.Admin;
import org.springframework.stereotype.Component;

@Component
public class AdminConverter {

    public AdminDto toDto(Admin admin) {
        return AdminDto.builder()
                .id(admin.getId())
                .firstName(admin.getFirstName())
                .lastName(admin.getLastName())
                .build();
    }

    public Admin fromDto(AdminDto admin) {
        return Admin.builder()
                .id(admin.getId())
                .firstName(admin.getFirstName())
                .lastName(admin.getLastName())
                .build();
    }
}
