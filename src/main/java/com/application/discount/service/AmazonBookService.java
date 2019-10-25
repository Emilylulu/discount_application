package com.application.discount.service;

import com.application.discount.domain.AmazonBaseline;
import com.application.discount.domain.AmazonBaselineCategory;
import com.application.discount.domain.AmazonBaselineReview;
import com.application.discount.exception.ItemNotFoundException;
import com.application.discount.repository.AmazonBaselineCategoryRepository;
import com.application.discount.repository.AmazonBaselineRepository;
import com.application.discount.repository.AmazonReviewsRepository;
import com.application.discount.service.dto.AmazonBookDto;
import com.application.discount.service.dto.ProductDetailDto;
import com.application.discount.service.dto.ProductReviewDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class AmazonBookService {
    @Autowired
    private AmazonBaselineRepository amazonBaselineRepository;
    @Autowired
    private AmazonBaselineCategoryRepository amazonBaselineCategoryRepository;
    @Autowired
    private AmazonReviewsRepository amazonReviewsRepository;

    public List<AmazonBookDto> getAllItems() {
        Set<String> bookCategoryIds = amazonBaselineCategoryRepository.findAllByCategory("Books")
            .stream()
            .map(AmazonBaselineCategory::getItemId)
            .collect(Collectors.toSet());
        List<AmazonBaseline> allItems = amazonBaselineRepository.findAll();
        return allItems.stream()
            .filter(item -> bookCategoryIds.contains(item.getId()))
            .map(amazonBook -> {
                AmazonBookDto dto = new AmazonBookDto();
                BeanUtils.copyProperties(amazonBook, dto);
                return dto;
            })
            .collect(Collectors.toList());
    }

    public ProductDetailDto getOneItem(String id) {

        AmazonBaseline oneItem = amazonBaselineRepository.findById(id)
            .orElseThrow(() -> new ItemNotFoundException(id));
        ProductDetailDto dto = new ProductDetailDto();
        BeanUtils.copyProperties(oneItem, dto);
        return dto;
    }

    public List<ProductReviewDto> getReview(String id) {
        Set<String> bookReviews = amazonReviewsRepository.findAllByItemId(id)
            .stream()
            .map(AmazonBaselineReview::getItemId)
            .collect(Collectors.toSet());

        List<AmazonBaselineReview> reviews = amazonReviewsRepository.findAll();
        return reviews.stream()
            .filter(review -> bookReviews.contains(review.getItemId()))
            .map(amazonReview -> {
                ProductReviewDto dto = new ProductReviewDto();
                BeanUtils.copyProperties(amazonReview, dto);
                return dto;
            })
            .collect(Collectors.toList());
    }
}
