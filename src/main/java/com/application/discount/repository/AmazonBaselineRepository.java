package com.application.discount.repository;


import com.application.discount.domain.AmazonBaseline;
import com.application.discount.domain.AmazonBaselineReview;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface AmazonBaselineRepository extends JpaRepository<AmazonBaseline, String> {

}
