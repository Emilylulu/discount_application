package com.application.discount.web.rest;

import com.application.discount.domain.AmazonBaselineUserPurchaseHistory;
import com.application.discount.domain.User;
import com.application.discount.service.AmazonUserPurchaseHistoryService;
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
    private AmazonUserPurchaseHistoryService amazonUserPurchaseHistoryService;

    public UserPurchaseHistoryController(UserService userService, AmazonUserPurchaseHistoryService amazonUserPurchaseHistoryService) {
        this.userService = userService;
        this.amazonUserPurchaseHistoryService = amazonUserPurchaseHistoryService;
    }

    @PostMapping(path = "/add/{asin}")
    public void addItemToHistory(@PathVariable("asin") String asin){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        User user = userService.getUserWithAuthorities().orElseThrow(() -> new AuthenticationServiceException("Please login first!"));
        AmazonBaselineUserPurchaseHistory info = new AmazonBaselineUserPurchaseHistory();
        info.setUserId(String.valueOf(user.getId()));
        info.setAsin(asin);
        info.setPurchaseTime(df.format(new Date()));
        info.setPurchaseNumber(1);
        amazonUserPurchaseHistoryService.addProductToHistory(info);
    }

}
