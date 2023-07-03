package com.xml;

import org.apache.commons.lang3.StringUtils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: nero
 * Date: 2023-07-03
 * Time: 14:56
 *
 * @author nero
 */
public class XmlUtils {

    public static <T> String convertToXML(T t) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(t.getClass());
        StringWriter writer = new StringWriter();
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.marshal(t, writer);
        String xmlStr = writer.toString();
        xmlStr = StringUtils.replace(xmlStr, "&quot;", "'");
        return xmlStr;
    }

    public static void main(String[] args) throws JAXBException {
        RootDemo rootDemo = new RootDemo();
        List<LogDemo> data = new ArrayList<>();
        LogDemo logDemo = new LogDemo();
        logDemo.setId(123);
        logDemo.setName("123");
        data.add(logDemo);
        logDemo = new LogDemo();
        logDemo.setId(234);
        logDemo.setName("234");
        data.add(logDemo);
        rootDemo.setLOG4A(data);
        String s = XmlUtils.convertToXML(rootDemo);
        System.out.println(s);
    }
}
