package com.tqy.document.reader.extention.service;

import org.springframework.stereotype.Service;

/**
 * @author tengqingya
 * @create 2019-04-10 16:44
 */
@Service
public class TestService {
    public String test(String param){
        return  param + " testService";
    }
}
