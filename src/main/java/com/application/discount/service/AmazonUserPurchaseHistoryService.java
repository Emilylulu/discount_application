package com.application.discount.service;

import com.application.discount.domain.AmazonBaselineUserPurchaseHistory;
import com.application.discount.repository.AmazonBaseslineUserPurchaseHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@Transactional
public class AmazonUserPurchaseHistoryService {
    @Autowired
    private AmazonBaseslineUserPurchaseHistoryRepository amazonBaseslineUserPurchaseHistoryRepository;

//    public void addProductToHistory(String asin){
//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//        AmazonBaselineUserPurchaseHistory info = new AmazonBaselineUserPurchaseHistory();
//        //AmazonBaselineUserPurchaseHistoryDto info = new AmazonBaselineUserPurchaseHistoryDto();
//        info.setUserId("100");
//        info.setAsin(asin);
//        info.setPurchaseTime(df.format(new Date()));
//        info.setPurchaseNumber(1);
//        amazonBaseslineUserPurchaseHistoryRepository.save(info);
//    }
    public void addProductToHistory(AmazonBaselineUserPurchaseHistory info){
        amazonBaseslineUserPurchaseHistoryRepository.save(info);
    }
}
