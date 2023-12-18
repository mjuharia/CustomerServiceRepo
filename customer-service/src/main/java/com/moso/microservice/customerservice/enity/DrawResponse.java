package com.moso.microservice.customerservice.enity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;

@JsonFilter("DrawFilter")
@Entity(name="draw_response")
public class DrawResponse {
	
	private int builtDrawID;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="seq")
	private int dtDrawID;
	
	private int drawNumber;
	
	private long dtDealID;
	private Boolean success;
	
	@OneToMany(mappedBy = "iResponse")
	private List<Error> errorList;
	
	@JsonInclude()
	@Transient
	private List<FundingSource> lFundingSource;

	public DrawResponse() {
		super();
		// TODO Auto-generated constructor stub
	}



	public int getDtDrawID() {
		return dtDrawID;
	}

	public void setDtDrawID(int dtDrawID) {
		this.dtDrawID = dtDrawID;
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

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public List<Error> getErrorList() {
		return errorList;
	}

	public void setErrorList(List<Error> errorList) {
		this.errorList = errorList;
	}

	

	public int getDrawNumber() {
		return drawNumber;
	}



	public void setDrawNumber(int drawNumber) {
		this.drawNumber = drawNumber;
	}


	public List<FundingSource> getlFundingSource() {
		return lFundingSource;
	}

	public void setlFundingSource(List<FundingSource> lFundingSource) {
		this.lFundingSource = lFundingSource;
	}



	@Override
	public String toString() {
		return "DrawResponse [builtDrawID=" + builtDrawID + ", dtDrawID=" + dtDrawID + ", drawNumber=" + drawNumber
				+ ", dtDealID=" + dtDealID + ", success=" + success + ", errorList=" + errorList + ", lFundingSource="
				+ lFundingSource + "]";
	}

	
}
