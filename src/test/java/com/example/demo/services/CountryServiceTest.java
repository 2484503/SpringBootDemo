package com.example.demo.services;

import com.example.demo.model.entity.Country;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author lijn
 * @version 1.0
 * @date 2019/10/10 15:53
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class CountryServiceTest {

    @Autowired
    private CountryService countryService;

    @Test
    public void testId() {

        List<Country> list = countryService.testId("1");
        System.out.println(list);

        list = countryService.testId("2");
        list = countryService.testId("2");
        list = countryService.testId("2");

    }
}