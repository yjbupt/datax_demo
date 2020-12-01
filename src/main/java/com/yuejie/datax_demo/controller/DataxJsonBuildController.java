package com.yuejie.datax_demo.controller;


import com.baomidou.mybatisplus.extension.api.R;
import com.yuejie.datax_demo.dto.DataxJsonDto;
import com.yuejie.datax_demo.service.JsonService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/dataxJson")
public class DataxJsonBuildController {

    private JsonService jsonService;

    @PostMapping("/datax/buildJson")
    public String buildJson(@RequestBody DataxJsonDto dataxJsonDto){

        return jsonService.buildJobJson(dataxJsonDto);


    }
    @PostMapping("/datax/saveJson")
    public String saveJson(@RequestParam String jsonString,@RequestParam String filenName) throws IOException {

        return jsonService.saveJson(jsonString,filenName);

    }
}
