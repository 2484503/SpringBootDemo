package com.example.demo.mapper;

import com.example.demo.model.param.CountryParam;
import com.example.demo.model.vo.Country;

public interface CountryMapper {

    Country selectCountryByParam(CountryParam countryParam);
}