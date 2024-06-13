package com.lombard.strategy;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = RegularPricingStrategy.class, name = "regularPricingStrategy"),
        @JsonSubTypes.Type(value = DiscountPricingStrategy.class, name = "discountPricingStrategy"),
})
public interface PricingStrategy {
    double calculatePrice(double basePrice);
}
