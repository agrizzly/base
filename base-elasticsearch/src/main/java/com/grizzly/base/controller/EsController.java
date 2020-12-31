package com.grizzly.base.controller;


import com.grizzly.base.sevice.EsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.security.PublicKey;
import java.util.List;
import java.util.Map;

@RestController
public class EsController {

    @Autowired
    private EsService esService;

    @GetMapping("/save/{saveword}")
    public Boolean save(@PathVariable String saveword) throws IOException {
        esService.testSave(saveword);
        return true;
    }

    @GetMapping("/show/{keyword}")
    public List<Map<String,Object>> show(@PathVariable String keyword) throws IOException {
        return esService.testShow(keyword);
    }
}
