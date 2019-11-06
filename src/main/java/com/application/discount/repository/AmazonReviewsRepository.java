package com.application.discount.repository;


import com.application.discount.domain.AmazonBaselineReview;
import com.application.discount.service.dto.ProductReviewDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;

import java.util.Set;

public interface AmazonReviewsRepository extends JpaRepository<AmazonBaselineReview, String> {
    Set<AmazonBaselineReview> findAllByItemId(String itemId);
    @Query ("select c from AmazonBaselineReview c where c.itemId = :id")
//    Set<AmazonBaselineReview> findByItemId(@Param("item") String itemId, Pageable pageable);
    Page<AmazonBaselineReview> findByItemId(@Param("id") String id, Pageable pageable);





}
