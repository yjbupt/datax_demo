package com.yuejie.datax_demo.tool.datax.writer;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import com.yuejie.datax_demo.entity.DatabaseInfo;
import com.yuejie.datax_demo.tool.datax.DataxBasePlugin;
import com.yuejie.datax_demo.tool.po.DataxRdbmsPo;
import com.yuejie.datax_demo.util.Constants;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class BaseWriter extends DataxBasePlugin {

    @Override
    public Map<String, Object> build(DataxRdbmsPo dataxPluginPo) {
        Map<String, Object> writerObj = Maps.newLinkedHashMap();
        writerObj.put("name", getName());

        Map<String, Object> parameterObj = Maps.newLinkedHashMap();
//        parameterObj.put("writeMode", "insert");
        DatabaseInfo jobDatasource = dataxPluginPo.getDatabaseInfo();
        parameterObj.put("username", jobDatasource.getUser());
        parameterObj.put("password", jobDatasource.getPassword());
        parameterObj.put("column", dataxPluginPo.getRdbmsColumns());
        parameterObj.put("preSql", splitSql(dataxPluginPo.getPreSql()));
        parameterObj.put("postSql", splitSql(dataxPluginPo.getPostSql()));

        Map<String, Object> connectionObj = Maps.newLinkedHashMap();
        connectionObj.put("table", dataxPluginPo.getTables());
        connectionObj.put("jdbcUrl", jobDatasource.getDatabaseUrl());

        parameterObj.put("connection", ImmutableList.of(connectionObj));
        writerObj.put("parameter", parameterObj);

        return writerObj;
    }

    private String[] splitSql(String sql) {
        String[] sqlArr = null;
        if (StringUtils.isNotBlank(sql)) {
            Pattern p = Pattern.compile("\r\n|\r|\n|\n\r");
            Matcher m = p.matcher(sql);
            String sqlStr = m.replaceAll(Constants.STRING_BLANK);
            sqlArr = sqlStr.split(Constants.SPLIT_COLON);
        }
        return sqlArr;
    }
}
