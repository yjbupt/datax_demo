package com.yuejie.datax_demo.controller;

import com.yuejie.datax_demo.entity.DatabaseInfo;
import com.yuejie.datax_demo.service.DataSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dataSource")
public class DataSourceController {

    @Autowired
    private DataSourceService dataSourceService;

    @GetMapping("/list")
    public String getList(){
        List<DatabaseInfo> list=dataSourceService.selectAllDatasource();
        return list.toString();
    }
}
