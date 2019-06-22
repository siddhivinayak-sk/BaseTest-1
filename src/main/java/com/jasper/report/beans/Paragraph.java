package com.jasper.report.beans;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "paragraph")
public class Paragraph implements Serializable {
	private final static long serialVersionUID = 1L;

	@XmlAttribute(name = "lineSpacing")
	private String lineSpacing; 
	
	@XmlAttribute(name = "lineSpacingSize")
	private Float lineSpacingSize;
	
	@XmlAttribute(name = "firstLineIndent")
	private Float firstLineIndent;
	
	@XmlAttribute(name = "leftIndent")
	private Float leftIndent;
	
	@XmlAttribute(name = "rightIndent")
	private Float rightIndent;
	
	@XmlAttribute(name = "spacingBefore")
	private Float spacingBefore;
	
	@XmlAttribute(name = "spacingAfter")
	private Float spacingAfter;
	
	@XmlAttribute(name = "tabStopWidth")
	private int tabStopWidth;

	public String getLineSpacing() {
		return lineSpacing;
	}

	public void setLineSpacing(String lineSpacing) {
		this.lineSpacing = lineSpacing;
	}

	public Float getLineSpacingSize() {
		return lineSpacingSize;
	}

	public void setLineSpacingSize(Float lineSpacingSize) {
		this.lineSpacingSize = lineSpacingSize;
	}

	public Float getFirstLineIndent() {
		return firstLineIndent;
	}

	public void setFirstLineIndent(Float firstLineIndent) {
		this.firstLineIndent = firstLineIndent;
	}

	public Float getLeftIndent() {
		return leftIndent;
	}

	public void setLeftIndent(Float leftIndent) {
		this.leftIndent = leftIndent;
	}

	public Float getRightIndent() {
		return rightIndent;
	}

	public void setRightIndent(Float rightIndent) {
		this.rightIndent = rightIndent;
	}

	public Float getSpacingBefore() {
		return spacingBefore;
	}

	public void setSpacingBefore(Float spacingBefore) {
		this.spacingBefore = spacingBefore;
	}

	public Float getSpacingAfter() {
		return spacingAfter;
	}

	public void setSpacingAfter(Float spacingAfter) {
		this.spacingAfter = spacingAfter;
	}

	public int getTabStopWidth() {
		return tabStopWidth;
	}

	public void setTabStopWidth(int tabStopWidth) {
		this.tabStopWidth = tabStopWidth;
	}
	
	
	
}
