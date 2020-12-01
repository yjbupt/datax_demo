package com.yuejie.datax_demo;

import com.yuejie.datax_demo.service.DataxBuildJobService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShellBuildServiceTest {

    @Autowired
    private DataxBuildJobService dataxBuildJobService;

    @Test
    public void test() throws Exception {
//        String jsonString = new String("/home/datax/json");
//        String fileName = "test";
//        dataxBuildJobService.buildJobShell(jsonString , fileName);
        String fileName="E:\\datax_demo\\shell\\datax_shell\\test.bat";

        dataxBuildJobService.exeJob(fileName);
    }

}
