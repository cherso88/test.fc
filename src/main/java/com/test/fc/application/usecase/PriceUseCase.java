package com.test.fc.application.usecase;



import com.test.fc.domain.model.Price;

import java.time.LocalDateTime;

public interface PriceUseCase {
    Price getApplicablePrice(Long brandId, Long productId, LocalDateTime applicationDate);
}
