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
    "pen",
    "topPen",
    "bottomPen",
    "leftPen",
    "rightPen"
})
@XmlRootElement(name = "box")
public class Box implements Serializable {
	private final static long serialVersionUID = 1L;

	@XmlElement(name = "pen")
	private Pen pen;

	@XmlElement(name = "topPen")
	private TopPen topPen;
	
	@XmlElement(name = "leftPen")
	private LeftPen leftPen;
	
	@XmlElement(name = "rightPen")
	private RightPen rightPen;

	@XmlElement(name = "bottomPen")
	private BottomPen bottomPen;
	
	
	@XmlAttribute(name = "padding")
	private Float padding;
	
	@XmlAttribute(name = "topPadding")
	private Float topPadding;
	
	@XmlAttribute(name = "leftPadding")
	private Float leftPadding;
	
	@XmlAttribute(name = "bottomPadding")
	private Float bottomPadding;
	
	@XmlAttribute(name = "rightPadding")
	private Float rightPadding;
	

	public Pen getPen() {
		return pen;
	}

	public void setPen(Pen pen) {
		this.pen = pen;
	}

	public Float getPadding() {
		return padding;
	}

	public void setPadding(Float padding) {
		this.padding = padding;
	}

	public Float getTopPadding() {
		return topPadding;
	}

	public void setTopPadding(Float topPadding) {
		this.topPadding = topPadding;
	}

	public Float getLeftPadding() {
		return leftPadding;
	}

	public void setLeftPadding(Float leftPadding) {
		this.leftPadding = leftPadding;
	}

	public Float getBottomPadding() {
		return bottomPadding;
	}

	public void setBottomPadding(Float bottomPadding) {
		this.bottomPadding = bottomPadding;
	}

	public Float getRightPadding() {
		return rightPadding;
	}

	public void setRightPadding(Float rightPadding) {
		this.rightPadding = rightPadding;
	}
	
	
}
