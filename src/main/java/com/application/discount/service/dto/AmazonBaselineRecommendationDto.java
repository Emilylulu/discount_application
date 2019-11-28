package com.application.discount.service.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AmazonBaselineRecommendationDto {
    private String itemId;
    private String userId;
}
