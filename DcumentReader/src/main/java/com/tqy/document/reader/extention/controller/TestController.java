package com.tqy.document.reader.extention.controller;

import com.tqy.document.reader.extention.test.Test2;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author tengqingya
 * @create 2019-04-10 13:05
 */
@Controller
public class TestController {
    /**
     * 此处注入的test2没有在配置文件中配置
     * 配置文件中配置的是test
     * 在preProcessXml中修改test的配置为test2
     */
    @Autowired
    private Test2 test2;
    private static final Logger LOGGER = Logger.getLogger( TestController.class );
    @RequestMapping("/test")
    @ResponseBody
    public String test( HttpServletRequest httpRequest ){
        LOGGER.info(httpRequest.getRequestURI());
        return test2.test("hello ");
    }
}
