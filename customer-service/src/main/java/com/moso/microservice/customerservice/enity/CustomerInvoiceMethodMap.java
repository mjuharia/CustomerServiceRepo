package com.moso.microservice.customerservice.enity;

import java.sql.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity(name="customer_invoice_method_map")
public class CustomerInvoiceMethodMap {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="seq")
	private Integer Id;
	private Integer invoiceMethodId;
	private String invoiceMethod;
	private String createdBy;
	@CreationTimestamp
	private Date createdDate; 
	private String modifiedBy;
	@UpdateTimestamp
	private Date modifiedDate;
	private Boolean isActive;
	private Boolean isPrimary;
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private CustomerContact iCustomerContact;
	
	public CustomerInvoiceMethodMap() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public Integer getInvoiceMethodId() {
		return invoiceMethodId;
	}

	public void setInvoiceMethodId(Integer invoiceMethodId) {
		this.invoiceMethodId = invoiceMethodId;
	}

	public String getInvoiceMethod() {
		return invoiceMethod;
	}

	public void setInvoiceMethod(String invoiceMethod) {
		this.invoiceMethod = invoiceMethod;
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

	public Boolean getIsPrimary() {
		return isPrimary;
	}

	public void setIsPrimary(Boolean isPrimary) {
		this.isPrimary = isPrimary;
	}

	public CustomerContact getiCustomerContact() {
		return iCustomerContact;
	}

	public void setiCustomerContact(CustomerContact iCustomerContact) {
		this.iCustomerContact = iCustomerContact;
	}

	@Override
	public String toString() {
		return "CustomerInvoiceMethodMap [Id=" + Id + ", invoiceMethodId=" + invoiceMethodId + ", invoiceMethod="
				+ invoiceMethod + ", createdBy=" + createdBy + ", createdDate=" + createdDate + ", modifiedBy="
				+ modifiedBy + ", modifiedDate=" + modifiedDate + ", isActive=" + isActive + ", isPrimary=" + isPrimary
				+ ", iCustomerContact=" + iCustomerContact + "]";
	}
	
	
	
}
