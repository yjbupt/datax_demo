package com.yuejie.datax_demo.tool.datax;

import com.yuejie.datax_demo.tool.po.DataxRdbmsPo;

import java.util.Map;

public interface DataxPluginInterface {
    /**
     * 获取reader插件名称
     *
     * @return
     */
    String getName();

    /**
     * 构建
     *
     * @return dataxPluginPojo
     */
    Map<String, Object> build(DataxRdbmsPo dataxPluginPo);
}
