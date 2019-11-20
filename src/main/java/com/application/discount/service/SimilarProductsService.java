package com.application.discount.service;
import com.application.discount.domain.AmazonBaseline;
import com.application.discount.domain.AmazonBaselineCategory;
import com.application.discount.domain.SimilarProducts;
import com.application.discount.repository.AmazonBaselineRepository;
import com.application.discount.repository.SimilarProductsRespository;
import com.application.discount.service.dto.AmazonBookDto;
import com.application.discount.service.dto.ProductDetailDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SimilarProductsService {
//    @Autowired
//    private SimilarProductsRespository similarProductsRespository;
//    @Autowired
//    private AmazonBaselineRepository amazonBaselineRepository;
//
//    public List<ProductDetailDto> getSimilar (String id) {
//        Set<String> simiIds = similarProductsRespository.findAllById(id)
//            .stream()
//            .map(SimilarProducts::getRecId)
//            .collect(Collectors.toSet());
//        List<AmazonBaseline> allRecItems = amazonBaselineRepository.findAll();
//        return allRecItems.stream()
//            .filter(item -> simiIds.contains(item.getId()))
//            .map(simiPro -> {
//                ProductDetailDto dto = new ProductDetailDto();
//                BeanUtils.copyProperties(simiPro, dto);
//                return dto;
//            })
//            .collect(Collectors.toList());
//
//    }
}
