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

@Entity(name="customer_profile")
public class CustomerProfile {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="seq")
	private Integer Id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private Customer iCustomer;
	@OneToMany(mappedBy = "iCustomerProfile")
	@JsonIgnore
	private List<CustomerLocation> iCustomerLocations;
	
	private String profileType;
	private String createdBy;
	@CreationTimestamp
	private Date createdDate; 
	private String modifiedBy;
	@UpdateTimestamp
	private Date modifiedDate;
	private Boolean isActive;
	
	public CustomerProfile() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public Customer getiCustomer() {
		return iCustomer;
	}
	public void setiCustomer(Customer iCustomer) {
		this.iCustomer = iCustomer;
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
	public List<CustomerLocation> getiCustomerLocations() {
		return iCustomerLocations;
	}
	public void setiCustomerLocations(List<CustomerLocation> iCustomerLocations) {
		this.iCustomerLocations = iCustomerLocations;
	}
	public String getProfileType() {
		return profileType;
	}
	public void setProfileType(String profileType) {
		this.profileType = profileType;
	}
	@Override
	public String toString() {
		return "CustomerProfile [Id=" + Id + ", iCustomer=" + iCustomer + ", iCustomerLocations=" + iCustomerLocations
				+ ", profileType=" + profileType + ", createdBy=" + createdBy + ", createdDate=" + createdDate
				+ ", modifiedBy=" + modifiedBy + ", modifiedDate=" + modifiedDate + ", isActive=" + isActive + "]";
	}
	
}
