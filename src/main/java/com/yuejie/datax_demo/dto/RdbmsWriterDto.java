package com.yuejie.datax_demo.dto;

public class RdbmsWriterDto {

    private String preSql;

    private String postSql;

    public String getPreSql() {
        return preSql;
    }

    public void setPreSql(String preSql) {
        this.preSql = preSql;
    }

    public String getPostSql() {
        return postSql;
    }

    public void setPostSql(String postSql) {
        this.postSql = postSql;
    }
}
