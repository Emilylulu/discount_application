package com.application.discount.domain;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Date;

@Data
public class AmazonBaselineHistoryPK implements Serializable {
    @Id
    @Column(name = "userid")
    private String userId;

    @Id
    @Column(name = "asin", length = 11)
    private String itemId;

    @Id
    @Column(name = "purchase_time")
    private Date purchaseTime;
}
