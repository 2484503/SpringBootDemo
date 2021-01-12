package com.example.demo.services;

import org.springframework.stereotype.Service;

/**
 * @author lijn
 * @version 1.0
 * @date 2021/1/12 14:52
 */
@Service
public class InterfaceTestServiceImpl implements InterfaceTestService {
    @Override
    public void test() {
        System.out.println("测试");
    }
}
