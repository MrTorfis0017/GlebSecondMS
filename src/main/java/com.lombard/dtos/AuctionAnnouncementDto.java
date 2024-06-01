package com.lombard.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@Builder
public class AuctionAnnouncementDto {

    private Long id;

    private Date creationDate;

    private String description;

    private AdminDto admin;

    private Product product;

    private ProductType productType;

}
