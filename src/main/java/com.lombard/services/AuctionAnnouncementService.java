package com.lombard.services;

import com.lombard.converters.AuctionConverter;
import com.lombard.dtos.AuctionAnnouncementDto;
import com.lombard.entities.AuctionAnnouncement;
import com.lombard.repositories.AuctionAnnouncementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuctionAnnouncementService {

    private final AuctionAnnouncementRepository auctionAnnouncementRepository;

    private final AuctionConverter auctionConverter;

    public AuctionAnnouncementDto createAuctionAnnouncement(AuctionAnnouncementDto auctionAnnouncementDto) {
        AuctionAnnouncement auctionAnnouncement = auctionAnnouncementRepository.save(auctionConverter.fromDto(auctionAnnouncementDto));
        return auctionConverter.toDto(auctionAnnouncement);
    }
}
