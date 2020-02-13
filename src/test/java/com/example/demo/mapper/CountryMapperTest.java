package com.example.demo.mapper;

import com.example.demo.model.entity.Country;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * @author lijn
 * @version 1.0
 * @date 2020/1/14 11:11
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Transactional
public class CountryMapperTest {
    @Resource
    CountryMapper countryMapper;

    @Test
    public void insert() {
        int count = countryMapper.insert(Country.builder()
                .id(999)
                .country("test")
                .code("999")
                .isValid(1)
                .createTime(LocalDateTime.now())
                .updateTime(LocalDateTime.now()).build());

        System.out.println("------------" + count);
    }
}