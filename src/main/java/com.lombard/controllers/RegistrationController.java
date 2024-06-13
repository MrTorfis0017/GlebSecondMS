package com.lombard.controllers;

import com.lombard.dtos.AdminDto;
import com.lombard.services.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/lombard/site/registration")
public class RegistrationController {

    private final RegistrationService registrationService;

    @PostMapping("/admin")
    public AdminDto registerAdmin(@RequestBody AdminDto adminDto) {
        return registrationService.registerAdmin(adminDto);
    }
}
