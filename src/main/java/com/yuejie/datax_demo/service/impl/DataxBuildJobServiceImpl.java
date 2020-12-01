package com.yuejie.datax_demo.service.impl;

import com.yuejie.datax_demo.service.DataxBuildJobService;
import com.yuejie.datax_demo.util.Constants;
import com.yuejie.datax_demo.util.FileUtil;
import org.springframework.stereotype.Service;

import java.io.*;

@Service
public class DataxBuildJobServiceImpl implements DataxBuildJobService {
    @Override
    public String buildJobShell(String jsonName,String fileName) throws IOException {
//        String shellString = "#!/bin/bash\n" +
//                "source /etc/profile\n" +
//                "# 截至时间设置为当前时间戳\n" +
//                "end_time=$(date +%s)\n" +
//                "# 开始时间设置为60s前时间戳\n" +
//                "create_time=$(($end_time - 60))\n" +
//                "[dataxPy] [dataxJson]  >>[dataxLog].`date +%Y%m%d%H%M`  2>&1 &";
//        shellString = shellString.replace("[dataxPy]", Constants.DATAX_PY_ADDRESS)
//                .replace("[dataxJson]", jsonString)
//                .replace("[dataxLog]", Constants.DATAX_LOG_ADDRESS);
        // 拼接文件完整路径
        String exeString=new String();

        exeString = "python" + Constants.DATAX_PY_ADDRESS + Constants.DATAX_JSON_ADDRESS + jsonName ;

        File file= FileUtil.createFile(Constants.DATAX_SHELL_ADDRESS,fileName);
        // 将格式化后的字符串写入文件

        java.io.Writer write = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");

        write.write(exeString);

        write.flush();

        write.close();

        return fileName;

    }

    @Override
    public void exeJob(String filename) throws IOException {
        Process process ;
        try {
            process = Runtime.getRuntime().exec(filename);
            BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
            String sResult = sb.toString();
            System.out.println(sResult);

        }catch (IOException e){
            e.printStackTrace();
        }

    }


}
