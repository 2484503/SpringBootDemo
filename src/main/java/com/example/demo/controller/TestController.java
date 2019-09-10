package com.example.demo.controller;

import com.example.demo.services.CommonService;
import com.example.demo.services.TestService;
import com.example.demo.vo.Task;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("test")
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

    /**
     * @api {get} /test/selectByTableName 根据tableName查询
     * @apiDescription 根据tableName查询数据库
     * @apiName selectByTableName
     * @apiGroup test
     * @apiVersion 1.0.0
     * @apiParam {String} [tableName=tableA] 表名
     * @apiSampleRequest http://localhost:8080/test/selectByTableName
     * @apiSuccess (success 2000) {Task}   task   测试对象信息
     */
    @GetMapping("selectByTableName")
    Task selectByTableName(@RequestParam("tableName") String tableName) {
        System.out.println("查询了=" + tableName);
        return testService.selectListByTableName(tableName);
    }

    /**
     * @api {post} /test/testNotNull 测试@NotNull对字段的校验
     * @apiDescription 使用@Valid标签和@NotNull标签，对字段的空值进行校验，并返回自定义信息
     * @apiName testNotNull
     * @apiGroup test
     * @apiVersion 1.0.0
     * @apiParam {id} 123 任务实体
     * @apiSampleRequest http://localhost:8080/test/testNotNull
     * @apiParamExample {json} Request-Example:
     * {
     * "id": 4711
     * }
     * @apiSuccess (success 2000) {Task}   task   测试对象信息
     */
    @PostMapping(value = "testNotNull")
    Task testNotNull(@Valid @RequestBody Task task) {
        Map<String, Object> map = new HashMap<>();
        map.put("123", new Task());
        log.info("查询了={}", map);
        return task;
    }
}
