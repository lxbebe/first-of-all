package com.example.tliaswebmanagement.controller;

import com.example.tliaswebmanagement.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/clazzs")
@RestController
public class ClazzController {
    @Autowired
    private ClazzService classService;

}
