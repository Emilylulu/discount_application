package com.application.discount.web.rest;

import com.application.discount.domain.User;
import com.application.discount.service.AmazonHistoryService;
import com.application.discount.service.UserService;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@CrossOrigin
@RestController
@RequestMapping(path = "/purchaseHistory")
public class UserPurchaseHistoryController {
    private UserService userService;
    private AmazonHistoryService amazonHistoryService;

    public UserPurchaseHistoryController(UserService userService, AmazonHistoryService amazonHistoryService) {
        this.userService = userService;
        this.amazonHistoryService = amazonHistoryService;
    }

    @PostMapping(path = "/add/{asin}")
    public void addItemToHistory(@PathVariable("asin") String asin){
        User user = userService.getUserWithAuthorities().orElseThrow(() -> new AuthenticationServiceException("Please login first!"));
        amazonHistoryService.addHistory(String.valueOf(user.getId()),asin);
    }

}
