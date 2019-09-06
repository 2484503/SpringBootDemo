package com.example.demo.services.impl;

import com.example.demo.mapper.TaskMapper;
import com.example.demo.services.TestService;
import com.example.demo.vo.Task;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("testService")
public class TestServiceImpl implements TestService {
    @Resource
    private TaskMapper taskMapper;

    @Override
    public Task selectList(int id) {
        Task task = taskMapper.selectByPrimaryKey(id);
        return task;
    }

    @Override
    public Task selectListByTableName(String tableName) {
        Task task = taskMapper.selectByTableName(tableName);
        return task;
    }
}
