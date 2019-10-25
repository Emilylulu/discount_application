package com.application.discount.web.rest;

import com.application.discount.service.AmazonClothService;
import com.application.discount.service.dto.AmazonClothDto;
import com.application.discount.service.dto.ProductDetailDto;
import com.application.discount.service.dto.ProductReviewDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "/cloth")
//@RequestMapping(path = "/user")
public class ClothController {
    private AmazonClothService amazonClothService;

    public ClothController(AmazonClothService amazonClothService) {
        this.amazonClothService = amazonClothService;
    }
    @GetMapping(path = "/all")
    public List<AmazonClothDto> getAllItems() {
        return amazonClothService.getAllItems();
    }
    @GetMapping(path = "/user/{id}")
    public ProductDetailDto getOneItem(@PathVariable("id") String id) {
        return amazonClothService.getOneItem(id);
    }
}
