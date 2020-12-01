package com.yuejie.datax_demo;


import com.yuejie.datax_demo.dto.DataxJsonDto;
import com.yuejie.datax_demo.dto.RdbmsReaderDto;
import com.yuejie.datax_demo.dto.RdbmsWriterDto;
import com.yuejie.datax_demo.service.JsonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JsonServiceTest {

    @Autowired
    private JsonService jsonService;

    private DataxJsonDto dataxJsonDto;

    @Test
    public void test(){
        this.dataxJsonDto=new DataxJsonDto();
        dataxJsonDto.setRdbmsReader(new RdbmsReaderDto());
        dataxJsonDto.setRdbmsWriter(new RdbmsWriterDto());
        List<String> readList=new ArrayList<>();
        readList.add("id");
        readList.add("name");
        List<String> readTables=new ArrayList<>();
        readTables.add("dataSource");
        dataxJsonDto.setReaderColumns(readList);
        dataxJsonDto.setWriterColumns(readList);
        dataxJsonDto.setReaderDatasourceId(1l);
        dataxJsonDto.setReaderTables(readTables);
        dataxJsonDto.setWriterDatasourceId(1L);
        dataxJsonDto.setWriterTables(readTables);

        String res=jsonService.buildJobJson(dataxJsonDto);
        System.out.println(res);

        try {
            jsonService.saveJson(res,"test1.json");
        }catch (Exception e){
            e.printStackTrace();
        }


    }

}
