package com.panshi.h5api.controller;

import com.panshi.h5api.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class FeignController {
    @Autowired
    private HelloService helloService;

    @RequestMapping("/feignindex/{name}")
    public String indexFeign(@PathVariable String name){
        String index = helloService.index(name);
        System.out.println(index);
        return index;
    }
}