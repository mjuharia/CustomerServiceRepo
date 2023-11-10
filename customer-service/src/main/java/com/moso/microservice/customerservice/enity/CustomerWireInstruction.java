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

@Entity(name="customer_wire_instruction")
public class CustomerWireInstruction {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="seq")
	private Integer Id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private Customer iCustomer;
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private CustomerServicingGroup iCustomerServicingGroup;
	private String accountNumber;
	private String routingNumber;
	private String bankName;
	private String comments;
	private String createdBy;
	@CreationTimestamp
	private Date createdDate; 
	private String modifiedBy;
	@UpdateTimestamp
	private Date modifiedDate;
	private Boolean isActive;
	public CustomerWireInstruction() {
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
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getRoutingNumber() {
		return routingNumber;
	}
	public void setRoutingNumber(String routingNumber) {
		this.routingNumber = routingNumber;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
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
	@Override
	public String toString() {
		return "CustomerWireInstruction [Id=" + Id + ", iCustomer=" + iCustomer + ", accountNumber=" + accountNumber
				+ ", routingNumber=" + routingNumber + ", bankName=" + bankName + ", comments=" + comments
				+ ", createdBy=" + createdBy + ", createdDate=" + createdDate + ", modifiedBy=" + modifiedBy
				+ ", modifiedDate=" + modifiedDate + ", isActive=" + isActive + "]";
	}
	public CustomerServicingGroup getiCustomerServicingGroup() {
		return iCustomerServicingGroup;
	}
	public void setiCustomerServicingGroup(CustomerServicingGroup iCustomerServicingGroup) {
		this.iCustomerServicingGroup = iCustomerServicingGroup;
	}
	
	
}
