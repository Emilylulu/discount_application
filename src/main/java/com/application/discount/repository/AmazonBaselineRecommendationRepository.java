package com.application.discount.repository;


import com.application.discount.domain.AmazonBaselineRecommendation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AmazonBaselineRecommendationRepository extends JpaRepository<AmazonBaselineRecommendation, String> {
    List<AmazonBaselineRecommendation> findAllByUserId(String userId);
}
