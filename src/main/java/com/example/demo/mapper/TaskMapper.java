package com.example.demo.mapper;

import com.example.demo.vo.Task;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TaskMapper {

    Task selectByPrimaryKey(Integer id);


    Task selectByTableName(@Param("table_name") String table_name);

}