package com.application.discount.domain;

import lombok.Data;
import org.hibernate.annotations.Cache;

import javax.persistence.*;

import static org.hibernate.annotations.CacheConcurrencyStrategy.NONSTRICT_READ_WRITE;


@Entity(name = "baseline_userpurchasehistory")
@Table(name = "baseline_userpurchasehistory")
@Data
@Cache(usage = NONSTRICT_READ_WRITE)
@IdClass(AmazonBaselineUserPurchaseHistoryPK.class)
public class AmazonBaselineUserPurchaseHistory {
    @Id
    @Column(name = "userid")
    private String userId;

    @Column(name = "asin")
    private String asin;

    @Column(name = "purchaseTime")
    private String purchaseTime;

    @Column(name = "purchaseNumber")
    private int purchaseNumber;
}
