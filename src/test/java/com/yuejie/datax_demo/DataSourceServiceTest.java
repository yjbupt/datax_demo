package com.yuejie.datax_demo;


import com.yuejie.datax_demo.entity.DatabaseInfo;
import com.yuejie.datax_demo.service.DataSourceService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DataSourceServiceTest {

    @Autowired
    private DataSourceService dataSourceService;

    private DatabaseInfo databaseInfo;

    @Test
    public void test(){
        this.databaseInfo=new DatabaseInfo();
        databaseInfo.setDatabaseId(002l);
        databaseInfo.setName("sqlserver数据源");
        databaseInfo.setDatabaseName("dataxweb");
        databaseInfo.setDataSource("sqlserver");
        databaseInfo.setDatabaseUrl("456789");
        databaseInfo.setUser("root");
        databaseInfo.setPassword("123");
        databaseInfo.setDriverClass("sqlserver");
        dataSourceService.save(databaseInfo);
        for(DatabaseInfo databaseInfo:dataSourceService.selectAllDatasource()){
            System.out.println(databaseInfo.getDatabaseUrl());
        }

    }
}
