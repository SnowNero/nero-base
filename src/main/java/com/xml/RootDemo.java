package com.xml;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: nero
 * Date: 2023-07-03
 * Time: 15:51
 *
 * @author nero
 */
@Data
@XmlRootElement(name = "ROOT")
@XmlAccessorType(XmlAccessType.FIELD)
public class RootDemo {

    /*@XmlElementWrapper(name = "LOG4A")
    @XmlElement(name = "LOG4A")*/
    private List<LogDemo> LOG4A;

}
