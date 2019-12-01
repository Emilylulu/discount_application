package com.application.discount.web.rest;

import com.application.discount.domain.User;
import com.application.discount.service.AmazonHistoryService;
import com.application.discount.service.AmazonSaveService;
import com.application.discount.service.UserService;
import com.application.discount.service.dto.AmazonJewelryDto;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "/entities/save")
public class SaveController {
    private UserService userService;
    private AmazonSaveService amazonSaveService;

    public SaveController(UserService userService, AmazonSaveService amazonSaveService){
        this.userService = userService;
        this.amazonSaveService = amazonSaveService;
    }

    @GetMapping(path = "/all")
    public List<AmazonJewelryDto> getSaveItems() {
        User user = userService.getUserWithAuthorities().orElseThrow(() -> new AuthenticationServiceException("Please login first!"));
        return amazonSaveService.getSaveItems(String.valueOf(user.getId()));
    }

    @PostMapping(path = "/add/{asin}")
    public void addItemToHistory(@PathVariable("asin") String asin){
        User user = userService.getUserWithAuthorities().orElseThrow(() -> new AuthenticationServiceException("Please login first!"));
        amazonSaveService.addSave(String.valueOf(user.getId()),asin);
    }
}
