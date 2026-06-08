package com.example.tliaswebmanagement.service;

import com.example.tliaswebmanagement.pojo.Dept;

import java.util.List;

public interface DeptService {

    List<Dept> list();
    void deleteById(Integer id);
    void save(Dept dept);
    void update(Dept dept);

}
