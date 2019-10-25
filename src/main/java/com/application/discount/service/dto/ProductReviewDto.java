package com.application.discount.service.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductReviewDto {
    private String itemId;
    private String reviewerID;
    private String reviewText;
    private String reviewerName;
    private String reviewTime;
}
