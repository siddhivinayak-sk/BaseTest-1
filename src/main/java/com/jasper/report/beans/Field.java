package com.jasper.report.beans;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "properties"
})
@XmlRootElement(name = "field")
public class Field implements Serializable {
	private final static long serialVersionUID = 1L;

	@XmlAttribute(name = "name")
	private String name;
	
	@XmlAttribute(name = "class")
	private String classz;
	
	
	private List<Property> properties;

	public List<Property> getProperties() {
		return properties;
	}

	public void setProperties(List<Property> properties) {
		this.properties = properties;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClassz() {
		return classz;
	}

	public void setClassz(String classz) {
		this.classz = classz;
	}
	
	
}
