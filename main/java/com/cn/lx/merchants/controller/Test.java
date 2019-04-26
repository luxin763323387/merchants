package com.cn.lx.merchants.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author StevenLu
 * @date 2019/4/13
 */

@RestController
@RequestMapping("/test")
public class Test {

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
}
