package com.application.discount.service.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AmazonSearchDto {
    private String id;
    private String brand;
    private String imgUrl;
    private String price;
    private String title;
    private String description;
}

