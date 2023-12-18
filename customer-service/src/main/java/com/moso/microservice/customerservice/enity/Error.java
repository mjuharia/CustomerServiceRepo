package com.moso.microservice.customerservice.enity;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@JsonFilter("DrawFilter")
@Entity(name="error")
public class Error {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="seq")
	private int id;
	private String errorCode;
	private String errorDescription;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private DrawResponse iResponse;

	public Error() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorDescription() {
		return errorDescription;
	}

	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}

	public DrawResponse getiResponse() {
		return iResponse;
	}

	public void setiResponse(DrawResponse iResponse) {
		this.iResponse = iResponse;
	}

	@Override
	public String toString() {
		return "Error [id=" + id + ", errorCode=" + errorCode + ", errorDescription=" + errorDescription
				+ ", iResponse=" + iResponse + "]";
	}
	
	
}
