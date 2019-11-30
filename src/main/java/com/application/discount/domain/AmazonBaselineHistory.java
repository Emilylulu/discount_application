package com.application.discount.domain;

import lombok.Data;
import org.hibernate.annotations.Cache;

import javax.persistence.*;
import java.sql.Date;

import static org.hibernate.annotations.CacheConcurrencyStrategy.NONSTRICT_READ_WRITE;

@Entity(name = "baseline_userpurchasehistory")
@Table(name = "baseline_userpurchasehistory")
@Data
@Cache(usage = NONSTRICT_READ_WRITE)
@IdClass(AmazonBaselineHistoryPK.class)
public class AmazonBaselineHistory {
    @Id
    @Column(name = "userid")
    private String userId;

    @Id
    @Column(name = "asin", length = 11)
    private String itemId;

    @Id
    @Column(name = "purchase_time")
    private Date purchaseTime;

    @Column(name = "purchase_number")
    private int purchaseNumber;
}
