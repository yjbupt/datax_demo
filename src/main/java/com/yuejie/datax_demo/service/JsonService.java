package com.yuejie.datax_demo.service;

import com.yuejie.datax_demo.dto.DataxJsonDto;

import java.io.IOException;

public interface JsonService {

    String buildJobJson(DataxJsonDto dataxJsonDto);

    String saveJson(String jsonString,String fileName) throws IOException;



}
