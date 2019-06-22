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
    "columnHeader",
    "columnFooter",
    "tableHeader",
    "tableFooter",
    "detailCell",
    "properties",
    "printWhenExpression"
})
@XmlRootElement(name = "column")
public class Column implements Serializable {
	private final static long serialVersionUID = 1L;
	
	@XmlElement(name = "columnHeader")
	private ColumnHeader columnHeader;

	@XmlElement(name = "columnFooter")
	private ColumnFooter columnFooter;
	
	@XmlElement(name = "tableHeader")
	private TableHeader tableHeader;

	@XmlElement(name = "tableFooter")
	private TableFooter tableFooter;
	
	@XmlElement(name = "detailCell")
	private DetailCell detailCell;

	@XmlElement(name = "property")
	private List<Property> properties;
	
	@XmlAttribute(name = "width")
	private int width;

	@XmlAttribute(name = "uuid")
	private String uuid;
	
	@XmlElement(name = "printWhenExpression")
	private PrintWhenExpression printWhenExpression;
	
	
	public ColumnHeader getColumnHeader() {
		return columnHeader;
	}

	public void setColumnHeader(ColumnHeader columnHeader) {
		this.columnHeader = columnHeader;
	}

	public DetailCell getDetailCell() {
		return detailCell;
	}

	public void setDetailCell(DetailCell detailCell) {
		this.detailCell = detailCell;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public ColumnFooter getColumnFooter() {
		return columnFooter;
	}

	public void setColumnFooter(ColumnFooter columnFooter) {
		this.columnFooter = columnFooter;
	}

	public TableHeader getTableHeader() {
		return tableHeader;
	}

	public void setTableHeader(TableHeader tableHeader) {
		this.tableHeader = tableHeader;
	}

	public TableFooter getTableFooter() {
		return tableFooter;
	}

	public void setTableFooter(TableFooter tableFooter) {
		this.tableFooter = tableFooter;
	}

	public List<Property> getProperties() {
		return properties;
	}

	public void setProperties(List<Property> properties) {
		this.properties = properties;
	}

	public PrintWhenExpression getPrintWhenExpression() {
		return printWhenExpression;
	}

	public void setPrintWhenExpression(PrintWhenExpression printWhenExpression) {
		this.printWhenExpression = printWhenExpression;
	}
	
	
	
}
