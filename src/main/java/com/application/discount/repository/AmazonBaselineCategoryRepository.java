package com.application.discount.repository;

import com.application.discount.domain.AmazonBaselineCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface AmazonBaselineCategoryRepository extends JpaRepository<AmazonBaselineCategory, String> {
    Set<AmazonBaselineCategory> findAllByCategory(String category);
}
