package com.moso.microservice.customerservice.enity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonFilter;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@JsonFilter("DrawFilter")
@Entity(name="draw_docs")
public class DrawDocs {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="seq")
	private int builtDrawID;
	
	private int drawNumber;
	
	private long dtDealID;
	private String dtDealName;
	
	@OneToMany(mappedBy = "iDrawDocs")
	private List<ServicingDrawDocument> documentList;

	public DrawDocs() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getBuiltDrawID() {
		return builtDrawID;
	}

	public void setBuiltDrawID(int builtDrawID) {
		this.builtDrawID = builtDrawID;
	}

	public long getDtDealID() {
		return dtDealID;
	}

	public void setDtDealID(long dtDealID) {
		this.dtDealID = dtDealID;
	}

	public String getDtDealName() {
		return dtDealName;
	}

	public void setDtDealName(String dtDealName) {
		this.dtDealName = dtDealName;
	}

	public List<ServicingDrawDocument> getDocumentList() {
		return documentList;
	}

	public void setDocumentList(List<ServicingDrawDocument> documentList) {
		this.documentList = documentList;
	}

	

	public int getDrawNumber() {
		return drawNumber;
	}

	public void setDrawNumber(int drawNumber) {
		this.drawNumber = drawNumber;
	}

	@Override
	public String toString() {
		return "DrawDocs [builtDrawID=" + builtDrawID + ", drawNumber=" + drawNumber + ", dtDealID=" + dtDealID
				+ ", dtDealName=" + dtDealName + ", documentList=" + documentList + "]";
	}
	
	
}
