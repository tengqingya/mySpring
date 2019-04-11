package com.tqy.document.reader.extention.context;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.web.context.support.XmlWebApplicationContext;

/**
 * @author tengqingya
 * @create 2019-04-10 19:24
 */
public class MyXmlWebApplicationContext extends XmlWebApplicationContext {
    private static final Logger LOGGER = Logger.getLogger( MyXmlWebApplicationContext.class );
    @Override
    protected void initBeanDefinitionReader( XmlBeanDefinitionReader beanDefinitionReader ) {
        LOGGER.info("initBeanDefinitionReader......................");
        beanDefinitionReader.setDocumentReaderClass(MyDefaultBeanDefinitionDocumentReader.class);
    }
}
