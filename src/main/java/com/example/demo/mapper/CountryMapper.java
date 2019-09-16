package com.example.demo.mapper;

import com.example.demo.model.param.CountryParam;
import com.example.demo.model.entity.Country;

import java.util.List;

public interface CountryMapper {

    List<Country> selectCountryByParam(CountryParam countryParam);
}