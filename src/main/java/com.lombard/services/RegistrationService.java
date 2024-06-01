package com.lombard.services;

import com.lombard.converters.AdminConverter;
import com.lombard.dtos.AdminDto;
import com.lombard.entities.Admin;
import com.lombard.repositories.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegistrationService {

    private final AdminRepository adminRepository;

    private final AdminConverter adminConverter;

    public AdminDto registerAdmin(AdminDto adminDto) {
        Admin admin = adminRepository.save(adminConverter.fromDto(adminDto));
        return adminConverter.toDto(admin);
    }
}
