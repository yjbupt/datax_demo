package com.yuejie.datax_demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuejie.datax_demo.entity.DatabaseInfo;
import com.yuejie.datax_demo.mapper.DatabaseInfoMapper;
import com.yuejie.datax_demo.service.DataSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DataSourceServiceImpl extends ServiceImpl<DatabaseInfoMapper, DatabaseInfo> implements DataSourceService {


    @Resource
    private DatabaseInfoMapper databaseInfoMapper;
    @Override
    public List<DatabaseInfo> selectAllDatasource() {
        return databaseInfoMapper.selectList(null);
    }
}
