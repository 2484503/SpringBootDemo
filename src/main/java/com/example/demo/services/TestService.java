package com.example.demo.services;

import com.example.demo.vo.Task;

public interface TestService {

    Task selectList(int id);

    Task selectListByTableName(String tableName);

}
