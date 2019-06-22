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
    "printWhenExpression",
    "propList"
})
@XmlRootElement(name = "reportElement")
public class ReportElement implements Serializable {
	private final static long serialVersionUID = 1L;
	
	@XmlAttribute(name = "key")
	private String key;
	
	@XmlAttribute(name = "stretchType")
	private String stretchType;
	
	@XmlAttribute(name = "x")
	private int x;
	
	@XmlAttribute(name = "y")
	private int y;
	
	@XmlAttribute(name = "width")
	private int width;
	
	@XmlAttribute(name = "height")
	private int height;
	
	@XmlAttribute(name = "forecolor")
	private String forecolor;
	
	@XmlAttribute(name = "backcolor")
	private String backcolor;
	
	@XmlAttribute(name = "uuid")
	private String uuid;

	@XmlAttribute(name = "isRemoveLineWhenBlank")
	private Boolean isRemoveLineWhenBlank;
	
	@XmlAttribute(name = "isPrintInFirstWholeBand")
	private Boolean isPrintInFirstWholeBand;

	@XmlAttribute(name = "isPrintRepeatedValues")
	private Boolean isPrintRepeatedValues;
	
	@XmlAttribute(name = "style")
	private String style;
	
	@XmlAttribute(name = "mode")
	private String mode;
	
	@XmlElement(name = "printWhenExpression")
	private PrintWhenExpression printWhenExpression;
	
	@XmlAttribute(name = "positionType")
	private String positionType;
	
	@XmlElement(name = "property")
	private List<Property> propList;

	
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	
	public String getStretchType() {
		return stretchType;
	}

	public void setStretchType(String stretchType) {
		this.stretchType = stretchType;
	}

	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	
	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	
	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	
	public String getForecolor() {
		return forecolor;
	}

	public void setForecolor(String forecolor) {
		this.forecolor = forecolor;
	}

	
	public String getBackcolor() {
		return backcolor;
	}

	public void setBackcolor(String backcolor) {
		this.backcolor = backcolor;
	}

	
	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	
	public Boolean getIsRemoveLineWhenBlank() {
		return isRemoveLineWhenBlank;
	}

	public void setIsRemoveLineWhenBlank(Boolean isRemoveLineWhenBlank) {
		this.isRemoveLineWhenBlank = isRemoveLineWhenBlank;
	}

	
	public Boolean getIsPrintInFirstWholeBand() {
		return isPrintInFirstWholeBand;
	}

	public void setIsPrintInFirstWholeBand(Boolean isPrintInFirstWholeBand) {
		this.isPrintInFirstWholeBand = isPrintInFirstWholeBand;
	}

	
	public Boolean getIsPrintRepeatedValues() {
		return isPrintRepeatedValues;
	}

	public void setIsPrintRepeatedValues(Boolean isPrintRepeatedValues) {
		this.isPrintRepeatedValues = isPrintRepeatedValues;
	}

	
	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	
	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	
	public PrintWhenExpression getPrintWhenExpression() {
		return printWhenExpression;
	}

	public void setPrintWhenExpression(PrintWhenExpression printWhenExpression) {
		this.printWhenExpression = printWhenExpression;
	}

	
	public String getPositionType() {
		return positionType;
	}

	public void setPositionType(String positionType) {
		this.positionType = positionType;
	}

	public List<Property> getPropList() {
		return propList;
	}

	public void setPropList(List<Property> propList) {
		this.propList = propList;
	}
	
	
	
}
