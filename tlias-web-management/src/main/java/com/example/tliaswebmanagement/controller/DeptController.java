package com.example.tliaswebmanagement.controller;

import com.example.tliaswebmanagement.pojo.Dept;
import com.example.tliaswebmanagement.pojo.Result;
import com.example.tliaswebmanagement.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/depts")
public class DeptController {
    @Autowired
    private DeptService deptService;

    @GetMapping
    public Result list() {
        List<Dept> depts = deptService.list();
        return Result.success(depts);
    }
    //调用service拿数据 返回结果
    @DeleteMapping
    public Result delete(Integer id){
        System.out.println("根据id删除部门, id=" + id);
        deptService.deleteById(id);
        return Result.success();
    }
    @PostMapping
    public Result save(@RequestBody Dept dept){
        System.out.println("新增部门,dept="+dept);
        deptService.save(dept);
        return Result.success();
    }
}