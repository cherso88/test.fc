package com.test.fc.application.mapper;

import com.test.fc.application.dto.PriceResponseDTO;
import com.test.fc.domain.model.Price;
import org.springframework.stereotype.Component;

@Component
public class PriceMapper {

    public PriceResponseDTO toDTO(Price price) {
        return new PriceResponseDTO(
                price.getProductId(),
                price.getBrand().getId(),
                price.getPriceList(),
                price.getStartDate(),
                price.getEndDate(),
                price.getPrice()
        );
    }
}