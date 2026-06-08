package com.example.tliaswebmanagement.service;

import com.example.tliaswebmanagement.pojo.JobOption;

public interface ReportService {
    /**
     * 统计各个职位的员工人数
     * @return
     */
    JobOption getEmpJobData();
}