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
    "styles",
    "subDatasets",
    "queryStrings",
    "fields",
    "backgroud",
    "details"	  
})
@XmlRootElement(name = "jasperReport")
public class JasperReport implements Serializable {
	private final static long serialVersionUID = 1L;
	
	@XmlElement(name = "property")
	private List<Property> properties;
	
	@XmlElement(name = "style")
	private List<Style> styles;
	
	@XmlElement(name = "subDataset")
	private List<SubDataset> subDatasets;
	
	@XmlElement(name = "queryString")
	private List<QueryString> queryStrings;
	
	@XmlElement(name = "field")
	private List<Field> fields;
	
	@XmlElement(name = "backgroud")
	private Backgroud backgroud;
	
	@XmlElement(name = "detail")
	private List<Detail> details;
	
	public List<Property> getProperties() {
		return properties;
	}
	public void setProperties(List<Property> properties) {
		this.properties = properties;
	}
	public List<Style> getStyles() {
		return styles;
	}
	public void setStyles(List<Style> styles) {
		this.styles = styles;
	}
	public List<SubDataset> getSubDatasets() {
		return subDatasets;
	}
	public void setSubDatasets(List<SubDataset> subDatasets) {
		this.subDatasets = subDatasets;
	}
	public List<QueryString> getQueryStrings() {
		return queryStrings;
	}
	public void setQueryStrings(List<QueryString> queryStrings) {
		this.queryStrings = queryStrings;
	}
	public List<Field> getFields() {
		return fields;
	}
	public void setFields(List<Field> fields) {
		this.fields = fields;
	}
	public Backgroud getBackgroud() {
		return backgroud;
	}
	public void setBackgroud(Backgroud backgroud) {
		this.backgroud = backgroud;
	}
	public List<Detail> getDetails() {
		return details;
	}
	public void setDetails(List<Detail> details) {
		this.details = details;
	}
	
	
}
