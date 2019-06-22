package com.jasper.report.beans;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "imageExpression"
})
@XmlRootElement(name = "break")
public class Break extends BandElement implements Serializable {
	private final static long serialVersionUID = 1L;
	
	@XmlElement(name = "imageExpression")
	private ImageExpression imageExpression;

	public ImageExpression getImageExpression() {
		return imageExpression;
	}

	public void setImageExpression(ImageExpression imageExpression) {
		this.imageExpression = imageExpression;
	}
	
	
}
