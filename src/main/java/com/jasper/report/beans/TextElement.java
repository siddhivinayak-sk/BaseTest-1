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
	    "font",
	    "paragraph"
	})
@XmlRootElement(name = "textElement")
public class TextElement implements Serializable {
	private final static long serialVersionUID = 1L;

	@XmlAttribute(name = "textAlignment")
	private String textAlignment;
	
	@XmlAttribute(name = "verticalAlignment")
	private String verticalAlignment;
	
	@XmlAttribute(name = "rotation")
	private String rotation;
	
	@XmlAttribute(name = "markup")
	private String markup;

	@XmlElement(name = "font")
	private Font font;
	
	@XmlElement(name = "paragraph")
	private Paragraph paragraph;
	
	public String getTextAlignment() {
		return textAlignment;
	}

	public void setTextAlignment(String textAlignment) {
		this.textAlignment = textAlignment;
	}

	public String getVerticalAlignment() {
		return verticalAlignment;
	}

	public void setVerticalAlignment(String verticalAlignment) {
		this.verticalAlignment = verticalAlignment;
	}

	public String getRotation() {
		return rotation;
	}

	public void setRotation(String rotation) {
		this.rotation = rotation;
	}

	public String getMarkup() {
		return markup;
	}

	public void setMarkup(String markup) {
		this.markup = markup;
	}

	public Font getFont() {
		return font;
	}

	public void setFont(Font font) {
		this.font = font;
	}

	public Paragraph getParagraph() {
		return paragraph;
	}

	public void setParagraph(Paragraph paragraph) {
		this.paragraph = paragraph;
	}
	
	
	
}
