package com.jasper.report.beans;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "topPen")
public class TopPen implements Serializable {
	private final static long serialVersionUID = 1L;
	
	@XmlAttribute(name = "lineWidth")
	private Float lineWidth;

	@XmlAttribute(name = "lineColor")
	private String lineColor;

	@XmlAttribute(name = "lineStyle")
	private String lineStyle;

	public Float getLineWidth() {
		return lineWidth;
	}

	public void setLineWidth(Float lineWidth) {
		this.lineWidth = lineWidth;
	}

	public String getLineColor() {
		return lineColor;
	}

	public void setLineColor(String lineColor) {
		this.lineColor = lineColor;
	}

	public String getLineStyle() {
		return lineStyle;
	}

	public void setLineStyle(String lineStyle) {
		this.lineStyle = lineStyle;
	}
	
	
	
}
