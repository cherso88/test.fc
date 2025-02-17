package com.test.fc.domain.model;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Brand {
    private Long id;
    private String name;
}