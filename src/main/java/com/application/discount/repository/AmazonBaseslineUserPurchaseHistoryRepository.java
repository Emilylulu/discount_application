package com.application.discount.repository;

import com.application.discount.domain.AmazonBaselineUserPurchaseHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AmazonBaseslineUserPurchaseHistoryRepository extends JpaRepository<AmazonBaselineUserPurchaseHistory, String> {
    List<AmazonBaselineUserPurchaseHistory> findAllByUserId(String userId);
}
