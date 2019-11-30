package com.application.discount.repository;

import com.application.discount.domain.AmazonBaselineHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AmazonBaselineHistoryRepository extends JpaRepository<AmazonBaselineHistory, String> {
    List<AmazonBaselineHistory> findAllByUserId(String userId);
}
