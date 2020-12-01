package com.yuejie.datax_demo.tool.datax.writer;

import com.yuejie.datax_demo.tool.datax.DataxPluginInterface;

public class MysqlWriter extends BaseWriter implements DataxWriterInterface {
    @Override
    public String getName() {
        return "mysqlwriter";
    }
}
