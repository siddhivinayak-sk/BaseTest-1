package com.jasper.report.beans;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "properties",
    "staticTexts",
    "textFields",
    "lines",
    "ellipses",
    "rectangles",
    "images",
    "breaks",
    "componentElements"
})
@XmlRootElement(name = "band")
public class Band implements Serializable {
	private final static long serialVersionUID = 1L;
	
	@XmlAttribute(name = "height")
	private int height;
	
	@XmlAttribute(name = "splitType")
	private String splitType;

	@XmlElement(name = "property")
	private List<Property> properties;
	
	@XmlElement(name = "staticText")
	private List<StaticText> staticTexts;
	
	@XmlElement(name = "textField")
	private List<TextField> textFields;
	
	@XmlElement(name = "line")
	private List<Line> lines;
	
	@XmlElement(name = "ellipse")
	private List<Ellipse> ellipses;
	
	@XmlElement(name = "rectangle")
	private List<Rectangle> rectangles;
	
	@XmlElement(name = "image")
	private List<Image> images;
	
	@XmlElement(name = "break")
	private List<Break> breaks;
	
	@XmlElement(name = "componentElement")
	private List<ComponentElement> componentElements;

	
	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	
	public String getSplitType() {
		return splitType;
	}

	public void setSplitType(String splitType) {
		this.splitType = splitType;
	}

	

	public List<Property> getProperties() {
		return properties;
	}

	public void setProperties(List<Property> properties) {
		this.properties = properties;
	}

	public List<StaticText> getStaticTexts() {
		return staticTexts;
	}

	public void setStaticTexts(List<StaticText> staticTexts) {
		this.staticTexts = staticTexts;
	}

	public List<TextField> getTextFields() {
		return textFields;
	}

	public void setTextFields(List<TextField> textFields) {
		this.textFields = textFields;
	}

	public List<Line> getLines() {
		return lines;
	}

	public void setLines(List<Line> lines) {
		this.lines = lines;
	}

	public List<Ellipse> getEllipses() {
		return ellipses;
	}

	public void setEllipses(List<Ellipse> ellipses) {
		this.ellipses = ellipses;
	}

	public List<Rectangle> getRectangles() {
		return rectangles;
	}

	public void setRectangles(List<Rectangle> rectangles) {
		this.rectangles = rectangles;
	}

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	public List<Break> getBreaks() {
		return breaks;
	}

	public void setBreaks(List<Break> breaks) {
		this.breaks = breaks;
	}

	public List<ComponentElement> getComponentElements() {
		return componentElements;
	}

	public void setComponentElements(List<ComponentElement> componentElements) {
		this.componentElements = componentElements;
	}


	
}
