package com.application.discount.repository;

import com.application.discount.domain.AmazonBaselineReview;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface AmazonReviewsRepository extends JpaRepository<AmazonBaselineReview, String> {
    Set<AmazonBaselineReview> findAllByItemId(String itemId);

}
