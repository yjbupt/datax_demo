package com.yuejie.datax_demo.tool.datax;

import java.util.Map;

public interface DataxJsonInterface {

    Map<String, Object> buildSetting();

    Map<String, Object> buildContent();

    Map<String, Object> buildReader();

    Map<String, Object> buildWriter();

    Map<String, Object> buildJob();

}
