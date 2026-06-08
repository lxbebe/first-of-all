package com.example.tliaswebmanagement.service;

import com.example.tliaswebmanagement.pojo.Clazz;
import com.example.tliaswebmanagement.pojo.PageResult;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public interface ClazzService {
    PageResult page(Integer page, Integer pageSize, String name,  LocalDate begin, LocalDate end);
    List<Clazz> select();

}
