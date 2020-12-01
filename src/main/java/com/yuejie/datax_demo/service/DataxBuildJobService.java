package com.yuejie.datax_demo.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public interface DataxBuildJobService {

    String buildJobShell(String jsonString,String fileName) throws FileNotFoundException, UnsupportedEncodingException, Exception;

    void exeJob(String filename) throws IOException;
}
