package com.xml;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: nero
 * Date: 2023-07-03
 * Time: 15:33
 *
 * @author nero
 */
@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class LogDemo {

    @XmlElement(name = "id")
    private Integer id;

    @XmlElement(name = "name")
    private String name;
}
