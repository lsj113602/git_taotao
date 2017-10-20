package com.taotao.search.controller;

import com.taotao.search.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestController {
    @Autowired
    private TestService ts;
    @RequestMapping("test")
    public void test(String email){
        ts.test(email);
    }
}
