package com.application.discount.service;

import com.application.discount.domain.AmazonBaseline;
import com.application.discount.domain.AmazonBaselineCategory;
import com.application.discount.domain.AmazonBaselineReview;
import com.application.discount.domain.SimilarProducts;
import com.application.discount.exception.ItemNotFoundException;
import com.application.discount.repository.AmazonBaselineCategoryRepository;
import com.application.discount.repository.AmazonBaselineRepository;
import com.application.discount.repository.AmazonReviewsRepository;
import com.application.discount.repository.SimilarProductsRespository;
import com.application.discount.service.dto.AmazonBookDto;
import com.application.discount.service.dto.ProductDetailDto;
import com.application.discount.service.dto.ProductReviewDto;
import com.google.common.base.Converter;
import com.google.common.base.Function;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//import java.awt.print.Pageable;
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
    @Autowired
    private SimilarProductsRespository similarProductsRespository;

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
        //Pageable paging = PageRequest.of(pageNo, pageSize);
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
//        List<ProductReviewDto> reviews = amazonReviewsRepository.findAllByItemIdCustom(id, new PageRequest(0, 10));
//        return reviews;
    }
    public List<ProductReviewDto> loadReviewPage(String id, Pageable pageable) {
        int pageSize = 100;
        //id = "0000031887";
        pageable = PageRequest.of(0, pageSize);
        Page<AmazonBaselineReview> reviewPage = amazonReviewsRepository.findByItemId(id, pageable);
        int totalElements = (int) reviewPage.getTotalElements();
        Page<ProductReviewDto> reviewDtoPage = reviewPage.map(this::convertToReviewDto);
        List<ProductReviewDto> reviewPageList = reviewDtoPage.getContent();
        return reviewPageList;



    }
    private ProductReviewDto convertToReviewDto(AmazonBaselineReview baselineReview) {
        ProductReviewDto reviewdto = new ProductReviewDto();
        reviewdto.setItemId(baselineReview.getItemId());
        reviewdto.setReviewerID(baselineReview.getReviewerID());
        reviewdto.setReviewerName(baselineReview.getReviewerName());
        reviewdto.setReviewText(baselineReview.getReviewText());
        reviewdto.setReviewTime(baselineReview.getReviewTime());
        return reviewdto;


    }
    public int getRating (String id) {
        return amazonReviewsRepository.findAverageRating(id);

    }
    public List<ProductDetailDto> getSimilar(String id) {
        Set<String> simiIds = similarProductsRespository.findAllById(id)
            .stream()
            .map(SimilarProducts::getRecId)
            .collect(Collectors.toSet());
        List<AmazonBaseline> allRecItems = amazonBaselineRepository.findAll();
        return allRecItems.stream()
            .filter(item -> simiIds.contains(item.getId()))
            .map(simiPro -> {
                ProductDetailDto dto = new ProductDetailDto();
                BeanUtils.copyProperties(simiPro, dto);
                return dto;
            })
            .collect(Collectors.toList());

    }


}
