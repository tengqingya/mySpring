package com.tqy.document.reader.extention.controller;

import org.apache.log4j.Logger;
import org.springframework.http.HttpRequest;
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
    private static final Logger LOGGER = Logger.getLogger( TestController.class );
    @RequestMapping("/test")
    @ResponseBody
    public String test( HttpServletRequest httpRequest ){
        LOGGER.info(httpRequest.getRequestURI());
        return "suc";
    }
}
