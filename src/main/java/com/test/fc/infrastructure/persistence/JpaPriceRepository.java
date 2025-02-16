package com.test.fc.infrastructure.persistence;

import com.test.fc.infrastructure.persistence.entity.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.Optional;

public interface JpaPriceRepository extends JpaRepository<PriceEntity, Long> {

    @Query("SELECT p FROM PriceEntity p WHERE p.brand.id = :brandId " +
            "AND p.productId = :productId " +
            "AND p.startDate <= :applicationDate " +
            "AND p.endDate >= :applicationDate " +
            "ORDER BY p.priority DESC")
    Optional<PriceEntity> findApplicablePrice(
            @Param("brandId") Long brandId,
            @Param("productId") Long productId,
            @Param("applicationDate") LocalDateTime applicationDate);
}
