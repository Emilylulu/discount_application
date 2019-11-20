package com.application.discount.repository;

import com.application.discount.domain.AmazonBaseline;
import com.application.discount.domain.AmazonBaselineReview;
import com.application.discount.domain.SimilarProducts;
import com.application.discount.service.dto.ProductDetailDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.BitSet;
import java.util.List;
import java.util.Set;

@Repository
public interface SimilarProductsRespository extends JpaRepository<SimilarProducts, String> {
    @Query ("select c from SimilarProducts c where c.id = :id")
    Set<SimilarProducts> findAllById(@Param("id") String id);
}
