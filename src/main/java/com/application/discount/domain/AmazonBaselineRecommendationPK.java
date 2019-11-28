package com.application.discount.domain;

import lombok.Data;
import org.hibernate.annotations.Cache;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

import static org.hibernate.annotations.CacheConcurrencyStrategy.NONSTRICT_READ_WRITE;

@Data
public class AmazonBaselineRecommendationPK implements Serializable {
    @Id
    @Column(name = "uid", length = 60)
    private String userId;

    @Id
    @Column(name = "asin", length = 11)
    private String itemId;

}
