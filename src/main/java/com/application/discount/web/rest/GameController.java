package com.application.discount.web.rest;

import com.application.discount.service.AmazonGameService;
import com.application.discount.service.dto.AmazonGameDto;
import com.application.discount.service.dto.ProductDetailDto;
import com.application.discount.service.dto.ProductReviewDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "/game")
public class GameController {
    private AmazonGameService amazonGameService;

    public GameController(AmazonGameService amazonGameService) {
        this.amazonGameService = amazonGameService;
    }
    @GetMapping(path = "/all")
    public List<AmazonGameDto> getAllItems() {
        return amazonGameService.getAllItems();
    }
    @GetMapping(path = "/user/{id}")
    public ProductDetailDto getOneItem(@PathVariable("id") String id) {
        return amazonGameService.getOneItem(id);
    }

}
