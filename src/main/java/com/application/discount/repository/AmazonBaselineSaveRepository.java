package com.application.discount.repository;

import com.application.discount.domain.AmazonBaselineSave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AmazonBaselineSaveRepository extends JpaRepository<AmazonBaselineSave, String> {
    List<AmazonBaselineSave> findAllByUserId(String userId);
}
