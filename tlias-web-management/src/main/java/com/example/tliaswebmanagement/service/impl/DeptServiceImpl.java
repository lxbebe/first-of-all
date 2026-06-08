package com.example.tliaswebmanagement.service.impl;

import com.example.tliaswebmanagement.mapper.DeptMapper;
import com.example.tliaswebmanagement.pojo.Dept;
import com.example.tliaswebmanagement.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public List<Dept> list() {
        return deptMapper.list();
    }
    @Override
    public void deleteById(Integer id){
        deptMapper.deleteById(id);
    }
    @Override
    public void save(Dept dept){
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.insert(dept);

    }
    @Override
    public void update(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.update(dept);
    }
}
