package com.jasper.report.beans;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "patternExpression")
public class PatternExpression implements Serializable {
	private final static long serialVersionUID = 1L;
	
	@XmlValue
	@XmlJavaTypeAdapter(value = CDATAAdapter.class)
	private String patternExpression;

	public String getPatternExpression() {
		return patternExpression;
	}

	public void setPatternExpression(String patternExpression) {
		this.patternExpression = patternExpression;
	}
	
	
}
