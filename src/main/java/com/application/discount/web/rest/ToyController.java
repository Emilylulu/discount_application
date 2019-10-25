package com.application.discount.web.rest;

import com.application.discount.service.AmazonToyService;
import com.application.discount.service.dto.AmazonToyDto;
import com.application.discount.service.dto.ProductDetailDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "/toy")
public class ToyController {
    private AmazonToyService amazonToyService;

    public ToyController(AmazonToyService amazonToyService) {
        this.amazonToyService = amazonToyService;
    }
    @GetMapping(path = "/all")
    public List<AmazonToyDto> getAllItems() {
        return amazonToyService.getAllItems();
    }
    @GetMapping(path = "/user/{id}")
    public ProductDetailDto getOneItem(@PathVariable("id") String id) {
        return amazonToyService.getOneItem(id);
    }
}

