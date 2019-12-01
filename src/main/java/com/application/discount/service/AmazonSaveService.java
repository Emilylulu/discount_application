package com.application.discount.service;

import com.application.discount.domain.AmazonBaseline;
import com.application.discount.domain.AmazonBaselineSave;
import com.application.discount.repository.AmazonBaselineRepository;
import com.application.discount.repository.AmazonBaselineSaveRepository;
import com.application.discount.service.dto.AmazonJewelryDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class AmazonSaveService {
    @Autowired
    private AmazonBaselineSaveRepository amazonBaselineSaveRepository;
    @Autowired
    private AmazonBaselineRepository amazonBaselineRepository;

    public List<AmazonJewelryDto> getSaveItems(String id){
        Set<String> saveItemIds = amazonBaselineSaveRepository.findAllByUserId(id)
            .stream()
            .map(AmazonBaselineSave::getItemId)
            .collect(Collectors.toSet());

        List<AmazonBaseline> allItems = amazonBaselineRepository.findAll();
        return allItems.stream()
            .filter(item -> saveItemIds.contains(item.getId()))
            .map(amazonJewelry -> {
                AmazonJewelryDto dto = new AmazonJewelryDto();
                BeanUtils.copyProperties(amazonJewelry, dto);
                return dto;
            })
            .collect(Collectors.toList());
    }

    public void addSave(String userId, String itemId){

        AmazonBaselineSave info = new AmazonBaselineSave();
        info.setItemId(itemId);
        info.setUserId(userId);
        amazonBaselineSaveRepository.save(info);

    }
}
