package com.test.fc.application.service;

import com.test.fc.application.usecase.PriceUseCase;
import com.test.fc.domain.model.Price;
import com.test.fc.domain.repository.PriceRepository;
import com.test.fc.infrastructure.exception.PriceNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PriceService implements PriceUseCase {

    private final PriceRepository repository;

    public PriceService(PriceRepository repository) {
        this.repository = repository;
    }

    @Override
    public Price getApplicablePrice(Long brandId, Long productId, LocalDateTime applicationDate) {
        return repository.findApplicablePrice(brandId, productId, applicationDate)
                .orElseThrow(() -> new PriceNotFoundException("No applicable price found for product " + productId + " and brand " + brandId + " at " + applicationDate));
    }

}
