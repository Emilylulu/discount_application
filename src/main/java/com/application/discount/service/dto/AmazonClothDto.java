package com.application.discount.service.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AmazonClothDto {
    private String price;
    private String title;
    private String imgUrl;
    private String id;
}
