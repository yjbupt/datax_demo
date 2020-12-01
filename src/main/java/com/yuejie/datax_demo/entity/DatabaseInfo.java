package com.yuejie.datax_demo.entity;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;


@TableName("JDBC_DatabaseInfo")
public class DatabaseInfo {


    /**
     * id,自增主键
     */
    @TableId
    private Long databaseId;

    /**
     * 数据源名称
     */
    private String name;
    /**
     *数据源
     */
    private String dataSource;

    /**
     * 数据库名
     */
    private String databaseName;
    /**
     * jdbc的url
     */
    private String databaseUrl;

    /**
     * 用户名
     */
    private String user;

    /**
     * 密码
     */
    private String password;

    private String driverClass;

    /**
     * 创建时间
     */
//    private Date createDate;
//
//    /**
//     * 更新时间
//     */
//    private Date updateDate;

//    public Date getCreateDate() {
//        return createDate;
//    }
//
//    public void setCreateDate(Date createDate) {
//        this.createDate = createDate;
//    }
//
//    public Date getUpdateDate() {
//        return updateDate;
//    }
//
//    public void setUpdateDate(Date updateDate) {
//        this.updateDate = updateDate;
//    }

    public String getDriverClass() {
        return driverClass;
    }

    public void setDriverClass(String driverClass) {
        this.driverClass = driverClass;
    }

    public Long getDatabaseId() {
        return databaseId;
    }

    public void setDatabaseId(Long databaseId) {
        this.databaseId = databaseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDataSource() {
        return dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    public String getDatabaseUrl() {
        return databaseUrl;
    }

    public void setDatabaseUrl(String databaseUrl) {
        this.databaseUrl = databaseUrl;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}