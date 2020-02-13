package com.example.demo.mapper;

import com.example.demo.model.param.CountryParam;
import com.example.demo.model.entity.Country;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CountryMapper {

    List<Country> selectCountryByParam(CountryParam countryParam);

    int insert(Country country);
}