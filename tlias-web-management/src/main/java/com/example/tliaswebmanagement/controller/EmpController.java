package com.example.tliaswebmanagement.controller;


import com.example.tliaswebmanagement.pojo.Emp;
import com.example.tliaswebmanagement.pojo.PageResult;
import com.example.tliaswebmanagement.pojo.Result;
import com.example.tliaswebmanagement.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

/**
 * 员工管理
 */
@Slf4j
@RequestMapping("/emps")
@RestController
public class EmpController {

    @Autowired
    private EmpService empService;

    @GetMapping
//    public Result page(@RequestParam(defaultValue = "1") Integer page ,
//                       @RequestParam(defaultValue = "10") Integer pageSize){
//        log.info("查询员工信息, page={}, pageSize={}", page, pageSize);
//        PageResult pageResult = empService.page(page, pageSize);
//        return Result.success(pageResult);
//    }
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String name, Integer gender,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end) {
        log.info("查询请求参数： {}, {}, {}, {}, {}, {}", page, pageSize, name, gender, begin, end);
        PageResult pageResult = empService.page(page, pageSize, name, gender, begin, end);
        return Result.success(pageResult);
    }
    @DeleteMapping
    public Result delete(@RequestParam List<Integer> ids){
    empService.deleteByIds(ids);
        log.info("批量删除部门: ids={} ", Arrays.asList(ids));//不转list输出的是内存地址看不到真实id
        return Result.success();
    }
    /**
     * 查询回显
     */
    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id){//从url模板中提取变量的注解
        log.info("根据id查询员工的详细信息");
        Emp emp  = empService.getInfo(id);//因为回显是显示一个员工，所以使用Emp实体类来接受，而不是使用泛型
        return Result.success(emp);
    }
    @PutMapping
    public Result update(@RequestBody Emp emp){//此注解的作用为将HTTP中发送过来的json数据封装到实体类对象中去
        log.info("修改员工信息, {}", emp);
        empService.update(emp);
        return Result.success();
    }

}