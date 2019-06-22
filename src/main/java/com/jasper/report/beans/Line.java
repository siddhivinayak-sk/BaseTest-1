package com.jasper.report.beans;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "graphicElement"
})
@XmlRootElement(name = "line")
public class Line extends BandElement implements Serializable {
	private final static long serialVersionUID = 1L;
	
	@XmlAttribute(name = "direction")
	private String direction;
	
	@XmlElement(name = "graphicElement")
	private GraphicElement graphicElement;

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public GraphicElement getGraphicElement() {
		return graphicElement;
	}

	public void setGraphicElement(GraphicElement graphicElement) {
		this.graphicElement = graphicElement;
	}
	
	
}
