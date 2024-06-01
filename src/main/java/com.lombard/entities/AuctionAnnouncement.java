package com.lombard.entities;

import com.lombard.dtos.ProductType;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "AUCTION_ANNOUNCEMENT")
public class AuctionAnnouncement {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CREATION_DATE")
    private Date creationDate;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "PRODUCT_ID")
    private Long productId;

    @Column(name = "PRODUCT_TYPE")
    @Enumerated(EnumType.STRING)
    private ProductType productType;

    @ManyToOne
    @JoinColumn(name = "ADMIN_ID")
    private Admin admin;
}
