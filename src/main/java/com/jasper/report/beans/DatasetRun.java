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
    "connectionExpression"
})
@XmlRootElement(name = "datasetRun")
public class DatasetRun implements Serializable {
	private final static long serialVersionUID = 1L;
	
	@XmlElement(name = "connectionExpression")
	private ConnectionExpression connectionExpression;
	
	@XmlAttribute(name = "subDataset")
	private String subDataset;

	@XmlAttribute(name = "uuid")
	private String uuid;

	public ConnectionExpression getConnectionExpression() {
		return connectionExpression;
	}

	public void setConnectionExpression(ConnectionExpression connectionExpression) {
		this.connectionExpression = connectionExpression;
	}

	public String getSubDataset() {
		return subDataset;
	}

	public void setSubDataset(String subDataset) {
		this.subDataset = subDataset;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	
	
}
