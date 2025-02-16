package com.test.fc.domain.repository;

import com.test.fc.domain.model.Price;

import java.time.LocalDateTime;
import java.util.Optional;

public interface PriceRepository {
    Optional<Price> findApplicablePrice(Long brandId, Long productId, LocalDateTime applicationDate);
}