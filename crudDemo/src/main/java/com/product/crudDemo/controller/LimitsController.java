package com.product.crudDemo.controller;

import com.product.crudDemo.configurtions.Configuration;
import com.product.crudDemo.db1.entity.Limits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsController {

    @Autowired
    private Configuration config;
    @GetMapping("/limits")
    public Limits retrieveLimits(){
//        return new Limits(1,1000);
        return new Limits(config.getMinimum(),config.getMaximum());
    }
}
