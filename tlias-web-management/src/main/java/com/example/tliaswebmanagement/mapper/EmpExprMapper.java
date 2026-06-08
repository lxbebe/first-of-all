package com.example.tliaswebmanagement.mapper;

import com.example.tliaswebmanagement.pojo.EmpExpr;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface EmpExprMapper {

    /**
     * 批量插入员工工作经历信息
     */
    public void insertBatch(List<EmpExpr> exprList);

    void deleteByEmpIds(List<Integer> list);
}