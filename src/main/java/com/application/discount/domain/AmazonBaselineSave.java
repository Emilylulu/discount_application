package com.application.discount.domain;

import lombok.Data;
import org.hibernate.annotations.Cache;

import javax.persistence.*;

import static org.hibernate.annotations.CacheConcurrencyStrategy.NONSTRICT_READ_WRITE;

@Entity(name = "baseline_save")
@Table(name = "baseline_save")
@Data
@Cache(usage = NONSTRICT_READ_WRITE)
@IdClass(AmazonBaselineSavePK.class)
public class AmazonBaselineSave {
    @Id
    @Column(name = "uid", length = 20)
    private String userId;

    @Id
    @Column(name = "asin", length = 45)
    private String itemId;
}
