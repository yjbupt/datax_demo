package com.yuejie.datax_demo.dto;

import java.util.List;

public class DataxJsonDto {
    private Long readerDatasourceId;

    private List<String> readerTables;

    private List<String> readerColumns;

    private Long writerDatasourceId;

    private List<String> writerTables;

    private List<String> writerColumns;

    private RdbmsReaderDto rdbmsReader;

    private RdbmsWriterDto rdbmsWriter;

    public Long getReaderDatasourceId() {
        return readerDatasourceId;
    }

    public void setReaderDatasourceId(Long readerDatasourceId) {
        this.readerDatasourceId = readerDatasourceId;
    }

    public List<String> getReaderTables() {
        return readerTables;
    }

    public void setReaderTables(List<String> readerTables) {
        this.readerTables = readerTables;
    }

    public List<String> getReaderColumns() {
        return readerColumns;
    }

    public void setReaderColumns(List<String> readerColumns) {
        this.readerColumns = readerColumns;
    }

    public Long getWriterDatasourceId() {
        return writerDatasourceId;
    }

    public void setWriterDatasourceId(Long writerDatasourceId) {
        this.writerDatasourceId = writerDatasourceId;
    }

    public List<String> getWriterTables() {
        return writerTables;
    }

    public void setWriterTables(List<String> writerTables) {
        this.writerTables = writerTables;
    }

    public List<String> getWriterColumns() {
        return writerColumns;
    }

    public void setWriterColumns(List<String> writerColumns) {
        this.writerColumns = writerColumns;
    }

    public RdbmsReaderDto getRdbmsReader() {
        return rdbmsReader;
    }

    public void setRdbmsReader(RdbmsReaderDto rdbmsReader) {
        this.rdbmsReader = rdbmsReader;
    }

    public RdbmsWriterDto getRdbmsWriter() {
        return rdbmsWriter;
    }

    public void setRdbmsWriter(RdbmsWriterDto rdbmsWriter) {
        this.rdbmsWriter = rdbmsWriter;
    }
}
