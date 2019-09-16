package com.example.demo.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Country {

    private Integer id;

    private String country;

    private String code;

    private Integer isValid;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}