package com.tqy.document.reader.extention.context;

import com.sun.org.apache.xerces.internal.dom.DeferredElementNSImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.xml.DefaultBeanDefinitionDocumentReader;
import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * @author tengqingya
 * @create 2019-04-10 19:31
 */
public class MyDefaultBeanDefinitionDocumentReader extends DefaultBeanDefinitionDocumentReader {
    private static final Logger LOGGER = Logger.getLogger(MyDefaultBeanDefinitionDocumentReader.class);

    @Override
    protected void preProcessXml( Element root ) {
        LOGGER.info("preProcessXml...");
        NodeList nl = root.getChildNodes();
        for( int i = 0; i < nl.getLength(); i++ ) {
            Node node = nl.item(i);
            if( node instanceof Element && node instanceof DeferredElementNSImpl ) {
                DeferredElementNSImpl deferredElementNS = (DeferredElementNSImpl)node;
                String nodeName = deferredElementNS.getNodeName();
                if( "context:component-scan".equals(nodeName) ) {
                    NamedNodeMap attributes = deferredElementNS.getAttributes();
                    LOGGER.info(attributes.getNamedItem("base-package"));
                }
                NamedNodeMap attributes = deferredElementNS.getAttributes();
                LOGGER.info(attributes.getNamedItem("class"));
                if( "bean".equals(nodeName) && attributes.getNamedItem("class").toString().contains("extention") ) {

                    Attr aClass = deferredElementNS.getAttributeNode("class");
                    Attr id = deferredElementNS.getAttributeNode("id");
                    aClass.setValue("com.tqy.document.reader.extention.test.Test2");
                    id.setValue("test2");
                }
                //base-package="com.tqy.document.reader.extention.controller"
                //id="viewResolver"
            }
        }
    }

    @Override
    protected void postProcessXml( Element root ) {
        LOGGER.info("postProcessXml...");
        String bean = root.getAttribute("bean");
        NodeList context = root.getElementsByTagName("context");
        String nodeName = root.getNodeName();
        LOGGER.info(bean);
        LOGGER.info(context);
        LOGGER.info(nodeName);
    }
}
