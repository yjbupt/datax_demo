package com.yuejie.datax_demo.controller;

import com.yuejie.datax_demo.service.DataxBuildJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/dataxShell")
public class DataxShellController {

    @Autowired
    private DataxBuildJobService dataxBuildJobService;

    @PostMapping("/buildshell")
    public String buildShell(@RequestParam String jsonString, @RequestParam String filenName) throws Exception {

        return dataxBuildJobService.buildJobShell(jsonString,filenName);

    }

    @PostMapping("/exeshell")
    public void exeShell(@RequestParam String fileName) throws IOException {
        dataxBuildJobService.exeJob(fileName);
    }
}
