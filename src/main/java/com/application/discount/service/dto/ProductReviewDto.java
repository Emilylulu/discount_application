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
    private int rating;

    public ProductReviewDto(ProductReviewDto productReviewDto) {
        this.itemId = productReviewDto.getItemId();
        this.reviewerID = productReviewDto.getReviewerID();
        this.reviewText = productReviewDto.getReviewText();
        this.reviewerName = productReviewDto.getReviewerName();
        this.reviewTime = productReviewDto.getReviewTime();
        this.rating = productReviewDto.getRating();
    }

}
