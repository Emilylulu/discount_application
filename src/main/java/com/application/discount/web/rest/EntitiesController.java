package com.application.discount.web.rest;

import com.application.discount.domain.User;
import com.application.discount.service.AmazonMayLikeService;
import com.application.discount.service.UserService;
import com.application.discount.service.dto.AmazonJewelryDto;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "/entities/mayLike")
public class EntitiesController {
    private UserService userService;
    private AmazonMayLikeService amazonMayLikeService;

    public EntitiesController(UserService userService, AmazonMayLikeService amazonMayLikeService){
        this.userService = userService;
        this.amazonMayLikeService = amazonMayLikeService;
    }
    @GetMapping(path = "/all")
    public List<AmazonJewelryDto> getRecommendation() {
        User user = userService.getUserWithAuthorities().orElseThrow(() -> new AuthenticationServiceException("Please login first!"));
        return amazonMayLikeService.getRecommendationItems(String.valueOf(user.getId()));
    }
}
