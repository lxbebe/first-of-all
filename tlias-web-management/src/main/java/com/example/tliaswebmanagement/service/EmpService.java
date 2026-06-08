package com.example.tliaswebmanagement.service;

import com.example.tliaswebmanagement.pojo.Emp;
import com.example.tliaswebmanagement.pojo.LoginInfo;
import com.example.tliaswebmanagement.pojo.PageResult;

import java.time.LocalDate;
import java.util.List;

public interface EmpService {
    /**
     * 分页查询
     * 
     * @param page     页码
     * @param pageSize 每页记录数
     */
    PageResult page(Integer page, Integer pageSize, String name, Integer gender, LocalDate begin, LocalDate end);

    void save(Emp emp);
    void deleteByIds(List<Integer> ids);
    Emp getInfo(Integer id);
    /**
     * 更新员工信息
     * @param emp
     */
    void update(Emp emp);
    LoginInfo login(Emp emp);
}