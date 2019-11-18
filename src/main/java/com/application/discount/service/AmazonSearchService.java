package com.application.discount.service;
import com.application.discount.domain.AmazonBaseline;
import com.application.discount.repository.AmazonBaselineRepository;
import com.application.discount.service.dto.AmazonSearchDto;
import io.searchbox.client.JestClient;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.platform.commons.util.StringUtils;
@Service
@Transactional
public class AmazonSearchService {
    @Autowired
    JestClient jestClient;
    @Autowired
    private AmazonBaselineRepository amazonBaselineRepository;

    public List<AmazonSearchDto> getAllItems() {
        List<AmazonBaseline> allItems = amazonBaselineRepository.findAll();
        return allItems.stream().map(amazonItem -> {
            AmazonSearchDto dto = new AmazonSearchDto();
            BeanUtils.copyProperties(amazonItem, dto);
            return dto;
        })
            .collect(Collectors.toList());
    }

    //Search--------------------------------------------------------------------------------------------------------------------------
    public List<AmazonSearchDto> getlist(String keyWord){
        String dslStr = getSearchDsl(keyWord);
        System.err.println(dslStr);

        List<AmazonSearchDto> amazonSearchInfos = new ArrayList<>();
        Search search = new Search.Builder(dslStr).addIndex("amazon-search").addType("_doc").build();
        SearchResult execute = null;
        try {
            execute = jestClient.execute(search);
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<SearchResult.Hit<AmazonSearchDto, Void>> hits = execute.getHits(AmazonSearchDto.class);
        for (SearchResult.Hit<AmazonSearchDto, Void> hit : hits) {
            AmazonSearchDto source = hit.source;
            amazonSearchInfos.add(source);
        }

        System.out.println(amazonSearchInfos.size());
        /*
        return amazonSearchInfos.stream()
            .map(amazonSearch -> {
                AmazonSearchDto dto = new AmazonSearchDto();
                BeanUtils.copyProperties(amazonSearch, dto);
                return dto;
            })
            .collect(Collectors.toList());
         */
        return amazonSearchInfos;
    }

    public String getSearchDsl(String keyWord){
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();

        //must
        if(StringUtils.isNotBlank(keyWord)){
            MatchQueryBuilder mbTitle = new MatchQueryBuilder("title", keyWord);
            MatchQueryBuilder mbId = new MatchQueryBuilder("asin", keyWord);
            MatchQueryBuilder mbPrice = new MatchQueryBuilder("price", keyWord);;
            MatchQueryBuilder mbBrand = new MatchQueryBuilder("brand", keyWord);
            boolQueryBuilder.should(mbId).should(mbTitle).should(mbBrand).should(mbPrice);
        }

        searchSourceBuilder.query(boolQueryBuilder);
        return searchSourceBuilder.toString();
    }
    //---------------------------------------------------------------------------------------------------------------------------------
}
