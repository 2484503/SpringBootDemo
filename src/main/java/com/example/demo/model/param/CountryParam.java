package com.example.demo.model.param;

import lombok.Data;

import java.util.Date;

@Data
public class CountryParam {

    private Integer id;

    private String country;

    private String code;

    private int isValid;

    private Date createTime;

    private Date updateTime;
}