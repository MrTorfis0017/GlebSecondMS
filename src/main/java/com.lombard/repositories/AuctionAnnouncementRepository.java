package com.lombard.repositories;

import com.lombard.entities.AuctionAnnouncement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuctionAnnouncementRepository extends JpaRepository<AuctionAnnouncement, Long> {
}
