package com.lombard.converters;

import com.lombard.dtos.AdminDto;
import com.lombard.entities.Admin;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class AdminConverterTest {

    @InjectMocks
    private AdminConverter adminConverter;

    @Test
    public void toDtoTest() {
        Admin admin = new Admin();
        admin.setId(1L);
        admin.setFirstName("First name");
        admin.setLastName("Last name");

        AdminDto result = adminConverter.toDto(admin);
        assertEquals(admin.getId(), result.getId());
        assertEquals(admin.getFirstName(), result.getFirstName());
        assertEquals(admin.getLastName(), result.getLastName());
    }

    @Test
    public void fromDtoTest() {
        AdminDto admin = AdminDto.builder()
                .id(1L)
                .firstName("First name")
                .lastName("Last name")
                .build();

        Admin result = adminConverter.fromDto(admin);
        assertEquals(admin.getId(), result.getId());
        assertEquals(admin.getFirstName(), result.getFirstName());
        assertEquals(admin.getLastName(), result.getLastName());
    }
}
