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
    "staticTexts",
    "textFields",
    "lines",
    "ellipses",
    "rectangles",
    "images",
    "breaks",
    "componentElements",
    "box",
    "printWhenExpression"
})
@XmlRootElement(name = "tableHeader")
public class TableHeader implements Serializable {
	private final static long serialVersionUID = 1L;
	
	@XmlAttribute(name = "height")
	private int height;

	@XmlAttribute(name = "style")
	private String style;
	
	@XmlAttribute(name = "rowSpan")
	private int rowSpan;

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
	
	@XmlElement(name = "box")
	private Box box;
	
	@XmlElement(name = "printWhenExpression")
	private PrintWhenExpression printWhenExpression;
	

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
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

	public int getRowSpan() {
		return rowSpan;
	}

	public void setRowSpan(int rowSpan) {
		this.rowSpan = rowSpan;
	}

	public Box getBox() {
		return box;
	}

	public void setBox(Box box) {
		this.box = box;
	}

	public PrintWhenExpression getPrintWhenExpression() {
		return printWhenExpression;
	}

	public void setPrintWhenExpression(PrintWhenExpression printWhenExpression) {
		this.printWhenExpression = printWhenExpression;
	}

	
	
	
}
