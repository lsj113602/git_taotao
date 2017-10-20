package com.taotao.search.service.impl;

import com.taotao.search.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService{
    private Logger logger = LoggerFactory.getLogger(TestServiceImpl.class);
    @Override
    public void test(String email){
        logger.debug("你好："+email);
       // System.out.println("你好："+email);
    }
}
