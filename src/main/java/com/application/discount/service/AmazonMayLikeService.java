package com.application.discount.service;

import com.application.discount.domain.AmazonBaseline;
import com.application.discount.domain.AmazonBaselineRecommendation;
import com.application.discount.repository.AmazonBaselineRecommendationRepository;
import com.application.discount.repository.AmazonBaselineRepository;
import com.application.discount.service.dto.AmazonBaselineRecommendationDto;
import com.application.discount.service.dto.AmazonJewelryDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class AmazonMayLikeService {
    @Autowired
    private AmazonBaselineRecommendationRepository amazonBaselineRecommendationRepository;
    @Autowired
    private AmazonBaselineRepository amazonBaselineRepository;

    public List<AmazonJewelryDto> getRecommendationItems(String id){
        Set<String> jewCategoryIds = amazonBaselineRecommendationRepository.findAllByUserId(id)
            .stream()
            .map(AmazonBaselineRecommendation::getItemId)
            .collect(Collectors.toSet());

        List<AmazonBaseline> allItems = amazonBaselineRepository.findAll();
        return allItems.stream()
            .filter(item -> jewCategoryIds.contains(item.getId()))
            .map(amazonJewelry -> {
                AmazonJewelryDto dto = new AmazonJewelryDto();
                BeanUtils.copyProperties(amazonJewelry, dto);
                return dto;
            })
            .collect(Collectors.toList());
    }
}
