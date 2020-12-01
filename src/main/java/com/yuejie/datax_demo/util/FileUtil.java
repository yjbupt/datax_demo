package com.yuejie.datax_demo.util;

import java.io.File;
import java.io.IOException;

public class FileUtil {
    public static File createFile(String filePath, String fileName) throws IOException {
        File file=new File(filePath+fileName);

        File fileParent = file.getParentFile();//返回的是File类型,可以调用exsit()等方法
        String fileParentPath = file.getParent();
        if (!fileParent.exists()) {
            fileParent.mkdirs();// 能创建多级目录
        }
        if (!file.exists()) {
            file.createNewFile();
        }
        return file;
    }

}
