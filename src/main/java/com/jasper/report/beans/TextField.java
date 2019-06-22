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
    "textElement",
    "textFieldExpression",
    "patternExpression",
    "anchorNameExpression"
})
@XmlRootElement(name = "textField")
public class TextField extends BandElement implements Serializable {
	private final static long serialVersionUID = 1L;

	@XmlElement(name = "textElement")
	private TextElement textElement;
	
	@XmlElement(name = "textFieldExpression")
	private TextFieldExpression textFieldExpression;

	@XmlElement(name = "patternExpression")
	private PatternExpression patternExpression;

	@XmlElement(name = "anchorNameExpression")
	private AnchorNameExpression anchorNameExpression;
	
	@XmlAttribute(name = "isStretchWithOverflow")
	private Boolean isStretchWithOverflow;
	
	@XmlAttribute(name = "pattern")
	private String pattern;
	
	@XmlAttribute(name = "isBlankWhenNull")
	private Boolean isBlankWhenNull;

	public TextElement getTextElement() {
		return textElement;
	}

	public void setTextElement(TextElement textElement) {
		this.textElement = textElement;
	}

	public TextFieldExpression getTextFieldExpression() {
		return textFieldExpression;
	}

	public void setTextFieldExpression(TextFieldExpression textFieldExpression) {
		this.textFieldExpression = textFieldExpression;
	}

	public PatternExpression getPatternExpression() {
		return patternExpression;
	}

	public void setPatternExpression(PatternExpression patternExpression) {
		this.patternExpression = patternExpression;
	}

	public AnchorNameExpression getAnchorNameExpression() {
		return anchorNameExpression;
	}

	public void setAnchorNameExpression(AnchorNameExpression anchorNameExpression) {
		this.anchorNameExpression = anchorNameExpression;
	}

	public Boolean getIsStretchWithOverflow() {
		return isStretchWithOverflow;
	}

	public void setIsStretchWithOverflow(Boolean isStretchWithOverflow) {
		this.isStretchWithOverflow = isStretchWithOverflow;
	}

	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	public Boolean getIsBlankWhenNull() {
		return isBlankWhenNull;
	}

	public void setIsBlankWhenNull(Boolean isBlankWhenNull) {
		this.isBlankWhenNull = isBlankWhenNull;
	}

	
	
}
