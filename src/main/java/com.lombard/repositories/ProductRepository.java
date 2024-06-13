package com.lombard.repositories;

import com.lombard.dtos.CarPartsDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "${warehouse-url}", name = "warehouseClient")
public interface ProductRepository {
    @GetMapping("product/car-parts/{id}")
    CarPartsDto getCarPartById(@PathVariable(value = "id")
                                      Long id);
}
