package com.test.fc.infrastructure.persistence;

import com.test.fc.infrastructure.persistence.entity.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface JpaPriceRepository extends JpaRepository<PriceEntity, Long> {

    @Query("SELECT p FROM PriceEntity p WHERE p.brand.id = :brandId " +
            "AND p.productId = :productId " +
            "AND p.startDate <= :applicationDate " +
            "AND p.endDate >= :applicationDate " +
            "ORDER BY p.priority DESC")
    List<PriceEntity> findApplicablePrices(
            @Param("brandId") Long brandId,
            @Param("productId") Long productId,
            @Param("applicationDate") LocalDateTime applicationDate
    );

    default Optional<PriceEntity> findFirstApplicablePrice(Long brandId, Long productId, LocalDateTime applicationDate) {
        List<PriceEntity> prices = findApplicablePrices(brandId, productId, applicationDate);
        return prices.stream().findFirst();
    }
}
