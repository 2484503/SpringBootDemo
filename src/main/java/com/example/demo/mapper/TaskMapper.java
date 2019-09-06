package com.example.demo.mapper;

import com.example.demo.vo.Task;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TaskMapper {

    Task selectByPrimaryKey(Integer id);


    Task selectByTableName(String table_name);

}