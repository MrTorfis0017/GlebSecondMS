package com.lombard.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lombard.converters.AdminConverter;
import com.lombard.dtos.AdminDto;
import com.lombard.repositories.AdminRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RegisterControllerTest {

    @InjectMocks
    private RegistrationService registrationService;

    @Mock
    private AdminRepository adminRepository;

    @Mock
    private AdminConverter adminConverter;

    @Test
    public void registerAdminTest() throws JsonProcessingException {
        AdminDto expectedResult = AdminDto.builder()
                .id(1L)
                .firstName("First name")
                .lastName("Last name")
                .build();

        when(adminConverter.toDto(any())).thenReturn(expectedResult);

        AdminDto actualResult = registrationService.registerAdmin(expectedResult);

        ObjectMapper objectMapper = new ObjectMapper();
        assertEquals(objectMapper.writeValueAsString(expectedResult), objectMapper.writeValueAsString(actualResult));
    }

}
