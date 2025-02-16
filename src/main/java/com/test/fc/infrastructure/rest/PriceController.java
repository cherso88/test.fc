package com.test.fc.infrastructure.rest;

import com.test.fc.application.usecase.PriceUseCase;
import com.test.fc.application.mapper.PriceMapper;
import com.test.fc.application.dto.PriceResponseDTO;
import com.test.fc.domain.model.Price;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/prices")
public class PriceController {

    private final PriceUseCase priceUseCase;
    private final PriceMapper priceMapper;

    public PriceController(PriceUseCase priceUseCase, PriceMapper priceMapper) {
        this.priceUseCase = priceUseCase;
        this.priceMapper = priceMapper;
    }

    @GetMapping
    public PriceResponseDTO getPrice(
            @RequestParam LocalDateTime applicationDate,
            @RequestParam Long productId,
            @RequestParam Long brandId) {

        Price price = priceUseCase.getApplicablePrice(brandId, productId, applicationDate);
        return priceMapper.toDTO(price);

    }
}

