package com.application.discount.domain;

import lombok.Data;
import lombok.Getter;
import org.hibernate.annotations.Cache;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import static org.hibernate.annotations.CacheConcurrencyStrategy.NONSTRICT_READ_WRITE;

@Data
@Getter
@Table(name = "baseline_simitems")
@Entity
@Cache(usage = NONSTRICT_READ_WRITE)

public class SimilarProducts {

    @Column(name = "asin")
    private String id;

    @Id
    @Column(name = "rec_asin")
    private String recId;

}
