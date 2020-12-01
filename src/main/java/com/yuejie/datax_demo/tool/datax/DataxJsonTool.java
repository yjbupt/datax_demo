package com.yuejie.datax_demo.tool.datax;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.yuejie.datax_demo.dto.DataxJsonDto;
import com.yuejie.datax_demo.dto.RdbmsReaderDto;
import com.yuejie.datax_demo.dto.RdbmsWriterDto;
import com.yuejie.datax_demo.entity.DatabaseInfo;
import com.google.common.collect.Maps;
import com.yuejie.datax_demo.tool.datax.reader.MysqlReader;
import com.yuejie.datax_demo.tool.datax.writer.MysqlWriter;
import com.yuejie.datax_demo.tool.po.DataxRdbmsPo;
import com.yuejie.datax_demo.util.Constants;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataxJsonTool implements DataxJsonInterface {

    /**
     * 读取的表，根据datax示例，支持多个表
     * 目的表的表名称。支持写入一个或者多个表。当配置为多张表时，必须确保所有表结构保持一致
     */
    private List<String> readerTables;
    /**
     * 读取的字段
     */
    private List<String> readerColumns;
    /**
     * reader jdbc 数据源
     */
    private DatabaseInfo readerDatasource;
    /**
     * writer jdbc 数据源
     */
    private DatabaseInfo writerDatasource;
    /**
     * 写入的表
     */
    private List<String> writerTables;
    /**
     * 写入的字段
     */
    private List<String> writerColumns;

    /**
     * 这个用来存储reader的json
     */

    private Map<String, Object> buildReader;

    /**
     * 用来存储writer的json信息
     */

    private Map<String, Object> buildWriter;

    private RdbmsReaderDto rdbmsReaderDto;

    private RdbmsWriterDto rdbmsWriterDto;

    private DataxBasePlugin readerPlugin;

    private DataxBasePlugin writerPlugin;

    private Map<String, Object> extraParams = Maps.newHashMap();


    public void initReader(DataxJsonDto dataxJsonDto, DatabaseInfo readerDatasource) {

        this.readerDatasource = readerDatasource;
        this.readerTables = dataxJsonDto.getReaderTables();
        this.readerColumns = dataxJsonDto.getReaderColumns();
        //this.hiveReaderDto = dataxJsonDto.getHiveReader();
        this.rdbmsReaderDto = dataxJsonDto.getRdbmsReader();
        //this.hbaseReaderDto = dataxJsonDto.getHbaseReader();
        // reader 插件
        String datasource = readerDatasource.getDataSource();

        this.readerColumns = convertKeywordsColumns(datasource, this.readerColumns);


        readerPlugin = new MysqlReader();

        buildReader = buildReader();
    }

    public void initWriter(DataxJsonDto dataxJsonDto, DatabaseInfo readerDatasource) {
        this.writerDatasource = readerDatasource;
        this.writerTables = dataxJsonDto.getWriterTables();
        this.writerColumns = dataxJsonDto.getWriterColumns();
       // this.hiveWriterDto = dataxJsonDto.getHiveWriter();
        this.rdbmsWriterDto = dataxJsonDto.getRdbmsWriter();
       // this.hbaseWriterDto = dataxJsonDto.getHbaseWriter();
        //this.mongoDBWriterDto = dataxJsonDto.getMongoDBWriter();
        // writer
        String datasource = readerDatasource.getDataSource();
        this.writerColumns = convertKeywordsColumns(datasource, this.writerColumns);

        writerPlugin = new MysqlWriter();
        buildWriter = this.buildWriter();

    }




    private List<String> convertKeywordsColumns(String datasource, List<String> columns) {
        if (columns == null) {
            return null;
        }

        List<String> toColumns = new ArrayList<>();
        columns.forEach(s -> {
            toColumns.add(doConvertKeywordsColumn(datasource, s));
        });
        return toColumns;
    }

    private String doConvertKeywordsColumn(String dbType, String column) {
        if (column == null) {
            return null;
        }

        column = column.trim();
        column = column.replace("[", "");
        column = column.replace("]", "");
        column = column.replace("`", "");
        column = column.replace("\"", "");
        column = column.replace("'", "");

        return String.format("'%s'",column);

    }




    @Override
    public Map<String, Object> buildSetting() {

        Map<String, Object> res = Maps.newLinkedHashMap();
        Map<String, Object> speedMap = Maps.newLinkedHashMap();
        Map<String, Object> errorLimitMap = Maps.newLinkedHashMap();
        speedMap.putAll(ImmutableMap.of("channel", 3, "byte", 1048576));
        errorLimitMap.putAll(ImmutableMap.of("record", 0, "percentage", 0.02));
        res.put("speed", speedMap);
        res.put("errorLimit", errorLimitMap);
        return res;
    }

    @Override
    public Map<String, Object> buildContent() {
        Map<String, Object> res = Maps.newLinkedHashMap();
        res.put("reader", this.buildReader);
        res.put("writer", this.buildWriter);
        return res;

    }

    @Override
    public Map<String, Object> buildReader() {
        DataxRdbmsPo dataxPluginPo = new DataxRdbmsPo();
        dataxPluginPo.setDatabaseInfo(readerDatasource);
        dataxPluginPo.setTables(readerTables);
        dataxPluginPo.setRdbmsColumns(readerColumns);
        dataxPluginPo.setSplitPk(rdbmsReaderDto.getReaderSplitPk());
        if (StringUtils.isNotBlank(rdbmsReaderDto.getQuerySql())) {
            dataxPluginPo.setQuerySql(rdbmsReaderDto.getQuerySql());
        }
        //where
        if (StringUtils.isNotBlank(rdbmsReaderDto.getWhereParams())) {
            dataxPluginPo.setWhereParam(rdbmsReaderDto.getWhereParams());
        }
        return readerPlugin.build(dataxPluginPo);
    }

    @Override
    public Map<String, Object> buildWriter() {
        DataxRdbmsPo dataxPluginPo = new DataxRdbmsPo();
        dataxPluginPo.setDatabaseInfo(writerDatasource);
        dataxPluginPo.setTables(writerTables);
        dataxPluginPo.setRdbmsColumns(writerColumns);
        dataxPluginPo.setPreSql(rdbmsWriterDto.getPreSql());
        dataxPluginPo.setPostSql(rdbmsWriterDto.getPostSql());
        return writerPlugin.build(dataxPluginPo);
    }

    @Override
    public Map<String, Object> buildJob() {
        Map<String, Object> res = Maps.newLinkedHashMap();
        Map<String, Object> jobMap = Maps.newLinkedHashMap();
        jobMap.put("setting", buildSetting());
        jobMap.put("content", ImmutableList.of(buildContent()));
        res.put("job", jobMap);
        return res;
    }

    private void buildColumns(List<String> columns, List<Map<String, Object>> returnColumns) {
        columns.forEach(c -> {
            Map<String, Object> column = Maps.newLinkedHashMap();
            column.put("name", c.split(Constants.SPLIT_SCOLON)[0]);
            column.put("type", c.split(Constants.SPLIT_SCOLON)[1]);
            returnColumns.add(column);
        });
    }
}
