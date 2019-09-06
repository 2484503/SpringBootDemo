package com.example.demo.controller;

import com.example.demo.services.CommonService;
import com.example.demo.services.TestService;
import com.example.demo.vo.Task;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
public class TestController {

    private final CommonService commonService;

    @Resource
    private TestService testService;

    public TestController(CommonService commonService) {
        this.commonService = commonService;
    }

    @GetMapping("select")
    Task select(@RequestParam("id") int id) {
        log.info("查询了={}", id);
        return testService.selectList(id);
    }

    @GetMapping("selectByTableName")
    Task selectByTableName(@RequestParam("tableName") String tableName) {
        System.out.println("查询了=" + tableName);
        return testService.selectListByTableName(tableName);
    }

    @PostMapping(value = "testNotNull")
    Task testNotNull(@RequestBody Task task) {
        Map<String, Object> map = new HashMap<>();
        map.put("123", new Task());
        log.info("查询了={}", map);
        return task;
    }
}
