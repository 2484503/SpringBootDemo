package com.example.demo.controller;

import com.example.demo.model.param.CountryParam;
import com.example.demo.model.vo.Country;
import com.example.demo.services.CountryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("country")
public class CountryController {

    @Resource
    private CountryService countryService;

    /**
     * @api {get} /country/selectCountry 查询国家
     * @apiDescription 根据参数，查询国家
     * @apiName selectCountry
     * @apiGroup country
     * @apiVersion 1.0.0
     * @apiParam {String} [country] 国家名称
     * @apiParam {String} [code] 国家code
     * @apiSampleRequest http://localhost:8080/country/selectCountry
     * @apiSuccess (success 200) {Country}   country   国家对象信息
     */
    @GetMapping("selectCountry")
    Country selectCountry(@ModelAttribute CountryParam countryParam) {

        Country country = countryService.selectCountry(countryParam);

        return country;
    }
}
