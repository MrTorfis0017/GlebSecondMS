package com.lombard.controllers;

import com.lombard.dtos.AuctionAnnouncementDto;
import com.lombard.repositories.ProductRepository;
import com.lombard.services.AuctionAnnouncementService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/lombard/site/auction")
public class AuctionAnnouncementController {

    private final AuctionAnnouncementService auctionAnnouncementService;
    @PostMapping("/create")
    public AuctionAnnouncementDto createAuctionAnnouncement(@RequestBody AuctionAnnouncementDto auctionAnnouncementDto){
        return auctionAnnouncementService.createAuctionAnnouncement(auctionAnnouncementDto);
    }
}
