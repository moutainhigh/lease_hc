package com.hc.lease.account.impl;

import com.hc.lease.account.service.TestService;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/4/7.
 */
@Service("testService")
public class TestServiceImpl implements TestService {
    public String test() {
        System.out.println("-----------TestServiceImpl--------------");
        return "TestServiceImpl";
    }
}
