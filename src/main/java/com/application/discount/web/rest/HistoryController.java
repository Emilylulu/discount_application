package com.application.discount.web.rest;

import com.application.discount.domain.User;
import com.application.discount.service.AmazonHistoryService;
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
@RequestMapping(path = "/entities/history")
public class HistoryController {
    private UserService userService;
    private AmazonHistoryService amazonHistoryService;

    public HistoryController(UserService userService, AmazonHistoryService amazonHistoryService){
        this.userService = userService;
        this.amazonHistoryService = amazonHistoryService;
    }
    @GetMapping(path = "/all")
    public List<AmazonJewelryDto> getHistoryItems() {
        User user = userService.getUserWithAuthorities().orElseThrow(() -> new AuthenticationServiceException("Please login first!"));
        return amazonHistoryService.getHistory(String.valueOf(user.getId()));
    }
}

