package com.application.discount.service.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AmazonBaselineUserPurchaseHistoryDto {
    private String useId;
    private String asin;
    private String purchaseTime;
    private int purchaseNumber;
}
