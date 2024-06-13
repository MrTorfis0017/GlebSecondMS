package com.lombard.converters;

import com.lombard.dtos.AdminDto;
import com.lombard.dtos.AuctionAnnouncementDto;
import com.lombard.dtos.CarPartsDto;
import com.lombard.dtos.ProductType;
import com.lombard.entities.Admin;
import com.lombard.entities.AuctionAnnouncement;
import com.lombard.repositories.AdminRepository;
import com.lombard.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AuctionConverterTest {

    @InjectMocks
    private AuctionConverter auctionConverter;

    @Mock
    private AdminConverter adminConverter;

    @Mock
    private ProductRepository productRepository;

    @Mock
    private AdminRepository adminRepository;

    @Test
    public void toDtoTest() {
        AuctionAnnouncement auctionAnnouncement = new AuctionAnnouncement();
        auctionAnnouncement.setId(1L);
        auctionAnnouncement.setDescription("Some desc");
        auctionAnnouncement.setProductType(ProductType.CAR_PARTS);

        AdminDto adminDto = AdminDto.builder()
                .id(1L)
                .firstName("First name")
                .lastName("Last name")
                .build();

        CarPartsDto carPartsDto = CarPartsDto.builder()
                .id(1L)
                .partNumber("321")
                .price(300.0)
                .compatability("Compatability")
                .build();

        when(productRepository.getCarPartById(any())).thenReturn(carPartsDto);
        when(adminConverter.toDto(any())).thenReturn(adminDto);

        AuctionAnnouncementDto auctionAnnouncementDto = auctionConverter.toDto(auctionAnnouncement);

        assertEquals(auctionAnnouncementDto.getId(), auctionAnnouncementDto.getId());
        assertEquals(auctionAnnouncementDto.getDescription(), auctionAnnouncementDto.getDescription());
    }

    @Test
    public void fromDtoTest() {
        AuctionAnnouncement auctionAnnouncement = new AuctionAnnouncement();
        auctionAnnouncement.setId(1L);
        auctionAnnouncement.setDescription("Some desc");
        auctionAnnouncement.setProductType(ProductType.CAR_PARTS);

        CarPartsDto carPartsDto = CarPartsDto.builder()
                .id(1L)
                .partNumber("321")
                .price(300.0)
                .compatability("Compatability")
                .build();

        Admin admin = Admin.builder()
                .id(1L)
                .firstName("First name")
                .lastName("Last name")
                .build();

        AdminDto adminDto = AdminDto.builder()
                .id(1L)
                .firstName("First name")
                .lastName("Last name")
                .build();

        AuctionAnnouncementDto auctionAnnouncementDto = AuctionAnnouncementDto.builder()
                .id(1L)
                .description("Some desc")
                .productType(ProductType.CAR_PARTS)
                .admin(adminDto)
                .product(carPartsDto)
                .build();

        carPartsDto.getPrice();
        when(adminRepository.getReferenceById(any())).thenReturn(admin);

        AuctionAnnouncement announcement = auctionConverter.fromDto(auctionAnnouncementDto);

        assertEquals(auctionAnnouncementDto.getId(), announcement.getId());
        assertEquals(auctionAnnouncementDto.getDescription(), announcement.getDescription());
    }
}
