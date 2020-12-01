package com.yuejie.datax_demo.dto;

public class RdbmsReaderDto {
    private String readerSplitPk;

    private String whereParams;

    private String querySql;

    public String getReaderSplitPk() {
        return readerSplitPk;
    }

    public void setReaderSplitPk(String readerSplitPk) {
        this.readerSplitPk = readerSplitPk;
    }

    public String getWhereParams() {
        return whereParams;
    }

    public void setWhereParams(String whereParams) {
        this.whereParams = whereParams;
    }

    public String getQuerySql() {
        return querySql;
    }

    public void setQuerySql(String querySql) {
        this.querySql = querySql;
    }
}
