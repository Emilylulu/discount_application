package com.application.discount.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

@Data
public class AmazonBaselineUserPurchaseHistoryPK implements Serializable {
    @Id
    @Column(name = "userid")
    private String userId;

    @Id
    @Column(name = "asin")
    private String asin;

    @Id
    @Column(name = "purchaseTime")
    private String purchaseTime;
}
