package com.yuejie.datax_demo.service.impl;

import com.alibaba.fastjson.JSON;
import com.yuejie.datax_demo.dto.DataxJsonDto;
import com.yuejie.datax_demo.entity.DatabaseInfo;
import com.yuejie.datax_demo.service.DataSourceService;
import com.yuejie.datax_demo.service.JsonService;
import com.yuejie.datax_demo.tool.datax.DataxJsonTool;
import com.yuejie.datax_demo.util.Constants;
import com.yuejie.datax_demo.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

@Service
public class JsonServiceImpl implements JsonService {


    @Autowired
    private DataSourceService dataSourceService;
    @Override
    public String buildJobJson(DataxJsonDto dataxJsonDto) {
        DataxJsonTool dataxJsonTool=new DataxJsonTool();

        DatabaseInfo readerDatabaseInfo =dataSourceService.getById(dataxJsonDto.getReaderDatasourceId());

        dataxJsonTool.initReader(dataxJsonDto,readerDatabaseInfo);

        DatabaseInfo writerDatabaseInfo =dataSourceService.getById(dataxJsonDto.getWriterDatasourceId());

        dataxJsonTool.initWriter(dataxJsonDto,writerDatabaseInfo);

        String jsonString=JSON.toJSONString(dataxJsonTool.buildJob());

        return jsonString;
    }

    @Override
    public String saveJson(String jsonString,String fileName) throws IOException {

        File file= FileUtil.createFile(Constants.DATAX_JSON_ADDRESS,fileName);

        java.io.Writer write = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");

        write.write(jsonString);

        write.flush();

        write.close();

        return fileName;

    }
}
