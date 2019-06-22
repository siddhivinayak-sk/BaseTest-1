package com.jasper.report.beans;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "box",
    "textElement",
    "text"
})
@XmlRootElement(name = "staticText")
public class StaticText extends BandElement implements Serializable {
	private final static long serialVersionUID = 1L;

	@XmlElement(name = "box")
	private Box box;
	
	@XmlElement(name = "textElement")
	private TextElement textElement;
	
	@XmlElement(name = "text")
	private Text text;

	public Box getBox() {
		return box;
	}

	public void setBox(Box box) {
		this.box = box;
	}

	public TextElement getTextElement() {
		return textElement;
	}

	public void setTextElement(TextElement textElement) {
		this.textElement = textElement;
	}

	public Text getText() {
		return text;
	}

	public void setText(Text text) {
		this.text = text;
	}
	
	
}
