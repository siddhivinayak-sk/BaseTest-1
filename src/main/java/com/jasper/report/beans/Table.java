package com.jasper.report.beans;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "datasetRun",
    "columnList"
})
@XmlRootElement(name = "table")
public class Table implements Serializable {
	private final static long serialVersionUID = 1L;
	
	@XmlElement(name = "datasetRun")
	private DatasetRun datasetRun;
	
	@XmlElement(name = "column")
	private List<Column>  columnList;

	public DatasetRun getDatasetRun() {
		return datasetRun;
	}

	public void setDatasetRun(DatasetRun datasetRun) {
		this.datasetRun = datasetRun;
	}

	public List<Column> getColumnList() {
		return columnList;
	}

	public void setColumnList(List<Column> columnList) {
		this.columnList = columnList;
	}
	
	
}
