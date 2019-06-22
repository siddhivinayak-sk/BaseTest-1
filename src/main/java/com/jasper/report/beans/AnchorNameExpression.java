package com.jasper.report.beans;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "anchorNameExpression")
public class AnchorNameExpression implements Serializable {
	private final static long serialVersionUID = 1L;
	
	@XmlValue
	@XmlJavaTypeAdapter(value = CDATAAdapter.class)
	private String anchorNameExpression;

	public String getAnchorNameExpression() {
		return anchorNameExpression;
	}

	public void setAnchorNameExpression(String anchorNameExpression) {
		this.anchorNameExpression = anchorNameExpression;
	}
	
	
}
