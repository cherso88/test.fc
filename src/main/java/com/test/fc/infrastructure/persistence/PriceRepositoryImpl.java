package com.test.fc.infrastructure.persistence;

import com.test.fc.domain.model.Brand;
import com.test.fc.domain.model.Price;
import com.test.fc.domain.repository.PriceRepository;
import com.test.fc.infrastructure.persistence.entity.BrandEntity;
import com.test.fc.infrastructure.persistence.entity.PriceEntity;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public class PriceRepositoryImpl implements PriceRepository {

    private final JpaPriceRepository jpaRepository;

    public PriceRepositoryImpl(JpaPriceRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Optional<Price> findApplicablePrice(Long brandId, Long productId, LocalDateTime applicationDate) {
        return jpaRepository.findApplicablePrice(brandId, productId, applicationDate).map(this::toDomain);
    }

    private Price toDomain(PriceEntity entity) {
        return Price.builder()
                .brand(toDomainBrand(entity.getBrand()))
                .startDate(entity.getStartDate())
                .endDate(entity.getEndDate())
                .priceList(entity.getPriceList())
                .productId(entity.getProductId())
                .priority(entity.getPriority())
                .price(entity.getPrice())
                .currency(entity.getCurrency())
                .build();
    }

    private Brand toDomainBrand(BrandEntity brandEntity) {
        return Brand.builder()
                .id(brandEntity.getId())
                .name(brandEntity.getName())
                .build();
    }
}


