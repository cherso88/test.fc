package com.test.fc.infrastructure.in;

import com.test.fc.application.PriceService;
import com.test.fc.application.dto.PriceResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/prices")
public class PriceController {

    private final PriceService priceService;

    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }

    @GetMapping
    public ResponseEntity<PriceResponseDTO> getPrice(
            @RequestParam LocalDateTime applicationDate,
            @RequestParam Long productId,
            @RequestParam Long brandId) {

        PriceResponseDTO priceResponse = priceService.getApplicablePrice(applicationDate, productId, brandId);
        return ResponseEntity.ok(priceResponse);
    }
}

