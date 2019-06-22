package com.jasper.report.beans;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class BandElement implements Serializable {
	private final static long serialVersionUID = 1L;
	
	@XmlElement(name = "reportElement")
	ReportElement reportElement;

	public ReportElement getReportElement() {
		return reportElement;
	}

	public void setReportElement(ReportElement reportElement) {
		this.reportElement = reportElement;
	}
	
	
	
}
