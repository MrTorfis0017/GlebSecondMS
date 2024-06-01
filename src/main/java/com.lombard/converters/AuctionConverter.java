package com.lombard.converters;

import com.lombard.dtos.AuctionAnnouncementDto;
import com.lombard.dtos.CarPartsDto;
import com.lombard.dtos.Product;
import com.lombard.dtos.ProductType;
import com.lombard.entities.AuctionAnnouncement;
import com.lombard.repositories.AdminRepository;
import com.lombard.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuctionConverter {

    private final AdminConverter adminConverter;

    private final ProductRepository productRepository;

    private final AdminRepository adminRepository;

    public AuctionAnnouncementDto toDto(AuctionAnnouncement auctionAnnouncement) {
        Product product = null;
        if (auctionAnnouncement.getProductType() == ProductType.CAR_PARTS) {
            product = productRepository.getCarPartById(auctionAnnouncement.getProductId());
        }
        return AuctionAnnouncementDto.builder()
                .id(auctionAnnouncement.getId())
                .creationDate(auctionAnnouncement.getCreationDate())
                .description(auctionAnnouncement.getDescription())
                .admin(adminConverter.toDto(auctionAnnouncement.getAdmin()))
                .product(product)
                .productType(auctionAnnouncement.getProductType())
                .build();
    }

    public AuctionAnnouncement fromDto(AuctionAnnouncementDto auctionAnnouncementDto) {
        Long productId = null;
        if (auctionAnnouncementDto.getProductType() == ProductType.CAR_PARTS) {
            CarPartsDto product = (CarPartsDto) auctionAnnouncementDto.getProduct();
            productId = product.getId();
        }
        return AuctionAnnouncement.builder()
                .id(auctionAnnouncementDto.getId())
                .creationDate(auctionAnnouncementDto.getCreationDate())
                .description(auctionAnnouncementDto.getDescription())
                .admin(adminRepository.getReferenceById(auctionAnnouncementDto.getAdmin().getId()))
                .productId(productId)
                .productType(auctionAnnouncementDto.getProductType())
                .build();
    }
}
