package com.application.discount.repository;


import com.application.discount.domain.AmazonBaseline;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AmazonBaselineRepository extends JpaRepository<AmazonBaseline, String> {
}
