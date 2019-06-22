package com.jasper.report.beans;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "font")
public class Font implements Serializable {
	private final static long serialVersionUID = 1L;

	@XmlAttribute(name = "fontName")
	private String fontName;
	
	@XmlAttribute(name = "size")
	private int size;
	
	@XmlAttribute(name = "isBold")
	private Boolean isBold;
	
	@XmlAttribute(name = "isItalic")
	private Boolean isItalic;
	
	@XmlAttribute(name = "isUnderline")
	private Boolean isUnderline;
	
	@XmlAttribute(name = "isStrikeThrough")
	private Boolean isStrikeThrough;
	
	@XmlAttribute(name = "isPdfEmbedded")
	private Boolean isPdfEmbedded;
	
	@XmlAttribute(name = "pdfFontName")
	private String pdfFontName;
	
	@XmlAttribute(name = "pdfEncoding")
	private String pdfEncoding;

	public String getFontName() {
		return fontName;
	}

	public void setFontName(String fontName) {
		this.fontName = fontName;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Boolean getIsBold() {
		return isBold;
	}

	public void setIsBold(Boolean isBold) {
		this.isBold = isBold;
	}

	public Boolean getIsItalic() {
		return isItalic;
	}

	public void setIsItalic(Boolean isItalic) {
		this.isItalic = isItalic;
	}

	public Boolean getIsUnderline() {
		return isUnderline;
	}

	public void setIsUnderline(Boolean isUnderline) {
		this.isUnderline = isUnderline;
	}

	public Boolean getIsStrikeThrough() {
		return isStrikeThrough;
	}

	public void setIsStrikeThrough(Boolean isStrikeThrough) {
		this.isStrikeThrough = isStrikeThrough;
	}

	public Boolean getIsPdfEmbedded() {
		return isPdfEmbedded;
	}

	public void setIsPdfEmbedded(Boolean isPdfEmbedded) {
		this.isPdfEmbedded = isPdfEmbedded;
	}

	public String getPdfFontName() {
		return pdfFontName;
	}

	public void setPdfFontName(String pdfFontName) {
		this.pdfFontName = pdfFontName;
	}

	public String getPdfEncoding() {
		return pdfEncoding;
	}

	public void setPdfEncoding(String pdfEncoding) {
		this.pdfEncoding = pdfEncoding;
	}
	
	
}
