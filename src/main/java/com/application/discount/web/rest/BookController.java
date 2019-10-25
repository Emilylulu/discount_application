package com.application.discount.web.rest;

import com.application.discount.service.AmazonBookService;
import com.application.discount.service.dto.AmazonBookDto;
import com.application.discount.service.dto.ProductDetailDto;
import com.application.discount.service.dto.ProductReviewDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "/book")
public class BookController {
    private AmazonBookService amazonBookService;

    public BookController(AmazonBookService amazonBookService) {
        this.amazonBookService = amazonBookService;
    }
    @GetMapping(path = "/all")
    public List<AmazonBookDto> getAllItems() {
        return amazonBookService.getAllItems();
    }
    @GetMapping(path = "/user/{id}")
    public ProductDetailDto getOneItem(@PathVariable("id") String id) {
        return amazonBookService.getOneItem(id);
    }
    @GetMapping(path = "/user/review/{id}")
    public List<ProductReviewDto> getAllReview(@PathVariable("id") String id) { return amazonBookService.getReview(id);}

}
