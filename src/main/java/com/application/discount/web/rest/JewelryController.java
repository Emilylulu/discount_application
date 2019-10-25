package com.application.discount.web.rest;

import com.application.discount.service.AmazonJewelryService;
import com.application.discount.service.dto.AmazonJewelryDto;
import com.application.discount.service.dto.ProductDetailDto;
import com.application.discount.service.dto.ProductReviewDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "/jewelry")
public class JewelryController {
    private AmazonJewelryService amazonJewelryService;

    public JewelryController(AmazonJewelryService amazonJewelryService) {
        this.amazonJewelryService = amazonJewelryService;
    }
    @GetMapping(path = "/all")
    public List<AmazonJewelryDto> getAllItems() {
        return amazonJewelryService.getAllItems();
    }
    @GetMapping(path = "/user/{id}")
    public ProductDetailDto getOneItem(@PathVariable("id") String id) {
        return amazonJewelryService.getOneItem(id);
    }
}
