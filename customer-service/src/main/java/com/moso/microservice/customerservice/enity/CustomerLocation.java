package com.moso.microservice.customerservice.enity;

import java.sql.Date;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity(name="customer_location")
public class CustomerLocation {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="seq")
	private Integer Id;
	private String locationAlias;
	private String address;
	private String city;
	private String state;
	private String country;
	@OneToMany(mappedBy = "iCustomerLocation")
	@JsonIgnore
	private List<CustomerServicingGroup> iCustomerServicingGroups;
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private CustomerProfile iCustomerProfile;
	private String postalcode;
	private String createdBy;
	@CreationTimestamp
	private Date createdDate; 
	private String modifiedBy;
	@UpdateTimestamp
	private Date modifiedDate;
	private Boolean isActive;
	
	public CustomerLocation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getLocationAlias() {
		return locationAlias;
	}

	public void setLocationAlias(String locationAlias) {
		this.locationAlias = locationAlias;
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

	
	public String getPostalcode() {
		return postalcode;
	}

	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}



	public List<CustomerServicingGroup> getiCustomerServicingGroups() {
		return iCustomerServicingGroups;
	}

	public void setiCustomerServicingGroups(List<CustomerServicingGroup> iCustomerServicingGroups) {
		this.iCustomerServicingGroups = iCustomerServicingGroups;
	}

	public CustomerProfile getiCustomerProfile() {
		return iCustomerProfile;
	}

	public void setiCustomerProfile(CustomerProfile iCustomerProfile) {
		this.iCustomerProfile = iCustomerProfile;
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

	@Override
	public String toString() {
		return "CustomerLocation [Id=" + Id + ", locationAlias=" + locationAlias + ", address=" + address + ", city="
				+ city + ", state=" + state + ", country=" + country + ", iCustomerServicingGroups="
				+ iCustomerServicingGroups + ", iCustomerProfile=" + iCustomerProfile + ", postalcode=" + postalcode
				+ ", createdBy=" + createdBy + ", createdDate=" + createdDate + ", modifiedBy=" + modifiedBy
				+ ", modifiedDate=" + modifiedDate + ", isActive=" + isActive + "]";
	}

		
}
