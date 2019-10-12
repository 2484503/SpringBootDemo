package com.example.demo.services;

import com.example.demo.constants.CacheAnno;
import com.example.demo.mapper.CountryMapper;
import com.example.demo.model.entity.Country;
import com.example.demo.model.param.CountryParam;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author lijn
 * @version 1.0
 * @date 2019/9/12 14:42
 */
@Service
public class CountryService {

    @Resource
    CountryMapper countryMapper;

    /**
     * 查询国家
     *
     * @param countryParam 查询参数
     * @return 国家信息
     */
    public List<Country> selectCountry(CountryParam countryParam) {

        List<Country> countryList = countryMapper.selectCountryByParam(countryParam);

        return countryList;
    }

    @CacheAnno(key = "#id")
    public List<Country> testId(String id) {
        return Lists.newArrayList(Country.builder().country("中国").build());
    }
}
