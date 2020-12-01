package com.yuejie.datax_demo.tool.datax.reader;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import com.yuejie.datax_demo.entity.DatabaseInfo;
import com.yuejie.datax_demo.tool.datax.DataxBasePlugin;
import com.yuejie.datax_demo.tool.po.DataxRdbmsPo;

import java.util.Map;

public abstract class BaseReader extends DataxBasePlugin {
    @Override
    public Map<String, Object> build(DataxRdbmsPo dataxPluginPo) {
        Map<String, Object> readerObj = Maps.newLinkedHashMap();
        readerObj.put("name", getName());
        Map<String, Object> parameterObj = Maps.newLinkedHashMap();
        Map<String, Object> connectionObj = Maps.newLinkedHashMap();

        DatabaseInfo databaseInfo = dataxPluginPo.getDatabaseInfo();
        parameterObj.put("username", databaseInfo.getUser());
        parameterObj.put("password", databaseInfo.getPassword());

        //判断是否是 querySql
        if (StrUtil.isNotBlank(dataxPluginPo.getQuerySql())) {
            connectionObj.put("querySql", ImmutableList.of(dataxPluginPo.getQuerySql()));
        } else {
            parameterObj.put("column", dataxPluginPo.getRdbmsColumns());
            //判断是否有where
            if (StringUtils.isNotBlank(dataxPluginPo.getWhereParam())) {
                parameterObj.put("where", dataxPluginPo.getWhereParam());
            }
            connectionObj.put("table", dataxPluginPo.getTables());
        }
        parameterObj.put("splitPk",dataxPluginPo.getSplitPk());
        connectionObj.put("jdbcUrl", ImmutableList.of(databaseInfo.getDatabaseUrl()));

        parameterObj.put("connection", ImmutableList.of(connectionObj));

        readerObj.put("parameter", parameterObj);

        return readerObj;
    }
}
