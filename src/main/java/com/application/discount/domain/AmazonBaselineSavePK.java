package com.application.discount.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

@Data
public class AmazonBaselineSavePK implements Serializable {
    @Id
    @Column(name = "uid", length = 60)
    private String userId;

    @Id
    @Column(name = "asin", length = 11)
    private String itemId;
}
