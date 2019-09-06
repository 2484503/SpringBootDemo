package com.example.demo.services;

import com.example.demo.vo.Task;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @author lijn
 * @version 1.0
 * @date 2019/8/8 14:20
 */
@Service("commonService")
public class CommonService {

    @Transactional
    public void add(@Valid @NotNull Integer num) {
        System.out.println("进入了service" + num);
    }

    public void test(@Valid Task task) {
        System.out.println("进入了service" + task);
    }
}
