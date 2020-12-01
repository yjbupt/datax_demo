package com.yuejie.datax_demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yuejie.datax_demo.entity.DatabaseInfo;

import java.util.List;

public interface DataSourceService extends IService<DatabaseInfo> {

    List<DatabaseInfo> selectAllDatasource();




}
