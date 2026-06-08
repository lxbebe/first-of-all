package com.example.tliaswebmanagement.mapper;

import com.example.tliaswebmanagement.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ClazzMapper {
    @Select("select * from clazz")
    List<Dept> list();
}
