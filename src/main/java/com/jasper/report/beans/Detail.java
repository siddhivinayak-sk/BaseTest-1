package com.jasper.report.beans;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "band"
})
@XmlRootElement(name = "detail")
public class Detail implements Serializable {
	private final static long serialVersionUID = 1L;

	private List<Band> band;
	
	public List<Band> getBand() {
		return band;
	}
	public void setBands(List<Band> band) {
		this.band = band;
	}
	
	
}
