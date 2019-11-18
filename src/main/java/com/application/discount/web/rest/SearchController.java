package com.application.discount.web.rest;

import com.application.discount.service.AmazonSearchService;
import com.application.discount.service.dto.AmazonSearchDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "/search")
public class SearchController {
    private AmazonSearchService amazonSearchService;
    public SearchController(AmazonSearchService amazonSearchService) {
        this.amazonSearchService = amazonSearchService;
    }
    @GetMapping(path = "/{keyWord}")
    public List<AmazonSearchDto> getSearchResult(@PathVariable("keyWord") String keyWord) {
        return amazonSearchService.getlist(keyWord);
    }
}
