package com.application.discount.web.rest;

import com.application.discount.service.AmazonPurseService;
import com.application.discount.service.dto.AmazonPurseDto;
import com.application.discount.service.dto.ProductDetailDto;
import com.application.discount.service.dto.ProductReviewDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "/purse")
public class PurseController {
    private AmazonPurseService amazonPurseService;

    public PurseController(AmazonPurseService amazonPurseService) {
        this.amazonPurseService = amazonPurseService;
    }
    @GetMapping(path = "/all")
    public List<AmazonPurseDto> getAllItems() {
        return amazonPurseService.getAllItems();
    }
    @GetMapping(path = "/user/{id}")
    public ProductDetailDto getOneItem(@PathVariable("id") String id) {
        return amazonPurseService.getOneItem(id);
    }
}
