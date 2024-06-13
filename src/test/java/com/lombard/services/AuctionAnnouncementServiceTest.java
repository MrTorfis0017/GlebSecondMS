package com.lombard.services;

import com.lombard.converters.AuctionConverter;
import com.lombard.dtos.AdminDto;
import com.lombard.dtos.AuctionAnnouncementDto;
import com.lombard.repositories.AuctionAnnouncementRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AuctionAnnouncementServiceTest {
    @InjectMocks
    private AuctionAnnouncementService auctionAnnouncementService;

    @Mock
    private AuctionAnnouncementRepository auctionAnnouncementRepository;

    @Mock
    private AuctionConverter auctionConverter;

    @Test
    public void createAuctionAnnouncementTest() {
        AdminDto adminDto = AdminDto.builder()
                .id(1L)
                .firstName("First name")
                .lastName("Last name")
                .build();
        AuctionAnnouncementDto auctionAnnouncementDto = AuctionAnnouncementDto.builder()
                .id(1L)
                .description("Some desc")
                .admin(adminDto)
                .build();
        when(auctionConverter.toDto(any())).thenReturn(auctionAnnouncementDto);
        auctionAnnouncementService.createAuctionAnnouncement(auctionAnnouncementDto);
    }
}
