package com.jasper.report.beans;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "band"
})
@XmlRootElement(name = "backgroud")
public class Backgroud implements Serializable {
	private final static long serialVersionUID = 1L;
	
	@XmlElement(name = "band")
	private Band band;

	public Band getBand() {
		return band;
	}

	public void setBand(Band band) {
		this.band = band;
	}
	
	
	
}
