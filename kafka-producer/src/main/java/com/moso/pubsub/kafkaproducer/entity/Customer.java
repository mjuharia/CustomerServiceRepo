package com.moso.pubsub.kafkaproducer.entity;

import java.sql.Date;


import org.springframework.stereotype.Component;

@Component
public class Customer {
	
	private Integer Id;
    private String Name;
	private String taxID;
	private String address;
	private String city;
	private String state;
	private String country;
	private String postalCcode;
	private String createdBy;
	
	private Date createdOn; 
	private String modifiedBy;
	
	private Date modifiedOn;
	

	
	private Boolean isActive;
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getTaxID() {
		return taxID;
	}

	public void setTaxID(String taxID) {
		this.taxID = taxID;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	

	public String getPostalCcode() {
		return postalCcode;
	}

	public void setPostalCcode(String postalCcode) {
		this.postalCcode = postalCcode;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}



	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "Customer [Id=" + Id + ", Name=" + Name + ", taxID=" + taxID + ", address=" + address + ", city=" + city
				+ ", state=" + state + ", country=" + country + ", postalCcode=" + postalCcode + ", createdBy="
				+ createdBy + ", createdOn=" + createdOn + ", modifiedBy=" + modifiedBy + ", modifiedOn=" + modifiedOn
				+ ", isActive=" + isActive + "]";
	}

	
	
	
}
