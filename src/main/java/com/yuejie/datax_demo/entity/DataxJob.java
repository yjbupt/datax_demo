package com.yuejie.datax_demo.entity;

import com.baomidou.mybatisplus.annotation.TableId;

public class DataxJob {

    /**
     * id,自增主键
     */
    private int jobId;
    /**
     * 任务名称
     */

    private String name;

    private String querySql;

    /**
     * 任务数据源id
     */
    private int readerDatabaseInfoId;

    private String writerTable;
    /**
     * 任务写入端id
     */
    private int writerDatabaseInfoId;
    private String writerPreSql;
    private String writerPostSql;

    /**
     * 任务cron表达式
     */
    private String jobCron;

    private String shellPath;

    public DataxJob(int jobId, String name, String querySql, int readerDatabaseInfoId, String writerTable, int writerDatabaseInfoId, String writerPreSql, String writerPostSql) {
        this.jobId = jobId;
        this.name = name;
        this.querySql = querySql;
        this.readerDatabaseInfoId = readerDatabaseInfoId;
        this.writerTable = writerTable;
        this.writerDatabaseInfoId = writerDatabaseInfoId;
        this.writerPreSql = writerPreSql;
        this.writerPostSql = writerPostSql;
    }



    public DataxJob(int jobId, String name, String querySql, int readerDatabaseInfoId, String writerTable, int writerDatabaseInfoId, String writerPreSql) {
        this.jobId = jobId;
        this.name = name;
        this.querySql = querySql;
        this.readerDatabaseInfoId = readerDatabaseInfoId;
        this.writerTable = writerTable;
        this.writerDatabaseInfoId = writerDatabaseInfoId;
        this.writerPreSql = writerPreSql;
    }

    public DataxJob(int jobId, String name, String querySql, int readerDatabaseInfoId, String writerTable, int writerDatabaseInfoId) {
        this.jobId = jobId;
        this.name = name;
        this.querySql = querySql;
        this.readerDatabaseInfoId = readerDatabaseInfoId;
        this.writerTable = writerTable;
        this.writerDatabaseInfoId = writerDatabaseInfoId;
    }

    public String getWriterPostSql() {
        return writerPostSql;
    }

    public void setWriterPostSql(String writerPostSql) {
        this.writerPostSql = writerPostSql;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuerySql() {
        return querySql;
    }

    public void setQuerySql(String querySql) {
        this.querySql = querySql;
    }

    public int getReaderDatabaseInfoId() {
        return readerDatabaseInfoId;
    }

    public void setReaderDatabaseInfoId(int readerDatabaseInfoId) {
        this.readerDatabaseInfoId = readerDatabaseInfoId;
    }

    public String getWriterTable() {
        return writerTable;
    }

    public void setWriterTable(String writerTable) {
        this.writerTable = writerTable;
    }

    public int getWriterDatabaseInfoId() {
        return writerDatabaseInfoId;
    }

    public void setWriterDatabaseInfoId(int writerDatabaseInfoId) {
        this.writerDatabaseInfoId = writerDatabaseInfoId;
    }

    public String getWriterPreSql() {
        return writerPreSql;
    }

    public void setWriterPreSql(String writerPreSql) {
        this.writerPreSql = writerPreSql;
    }
}
