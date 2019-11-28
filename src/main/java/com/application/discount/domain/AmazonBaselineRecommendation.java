package com.application.discount.domain;

import lombok.Data;
import lombok.Getter;
import org.hibernate.annotations.Cache;

import javax.persistence.*;

import java.io.Serializable;

import static org.hibernate.annotations.CacheConcurrencyStrategy.NONSTRICT_READ_WRITE;

@Entity(name = "baseline_recommendation")
@Table(name = "baseline_recommendation")
@Data
@Cache(usage = NONSTRICT_READ_WRITE)
@IdClass(AmazonBaselineRecommendationPK.class)
public class AmazonBaselineRecommendation implements Serializable {
    @Id
    @Column(name = "uid", length = 60)
    private String userId;

    @Id
    @Column(name = "asin", length = 11)
    private String itemId;

}
