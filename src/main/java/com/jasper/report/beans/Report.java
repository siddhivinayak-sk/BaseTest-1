package com.jasper.report.beans;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "detail"
})
@XmlRootElement(name = "report")
public class Report implements Serializable {
	private final static long serialVersionUID = 1L;
	
	@XmlElement(name = "detail")
	private Detail detail;
	
	

}
