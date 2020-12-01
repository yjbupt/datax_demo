package com.yuejie.datax_demo.tool.datax.reader;

import com.yuejie.datax_demo.tool.datax.DataxPluginInterface;

public class MysqlReader extends BaseReader implements DataxReaderInterface {
    @Override
    public String getName() {
        return "mysqlreader";
    }
}
