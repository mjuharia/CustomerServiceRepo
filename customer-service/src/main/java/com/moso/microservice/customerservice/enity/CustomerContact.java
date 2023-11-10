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

@Entity(name="customer_contact")
public class CustomerContact {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="seq")
	private Integer Id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private Customer iCustomer;
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private CustomerServicingGroup iCustomerServicingGroup;
	@OneToMany(mappedBy = "iCustomerContact")
	@JsonIgnore
	private List<CustomerInvoiceMethodMap> custInvoiceMethods; // fax, email, etc.
	private String firstName;
	private String lastName;
	private String emailAddress;
	private String phoneNumber;
	private String faxNumber;
	private String address;
	private String city;
	private String state;
	private String country;
	private String postalcode;
	private String createdBy;
	@CreationTimestamp
	private Date createdDate; 
	private String modifiedBy;
	@UpdateTimestamp
	private Date modifiedDate;
	private Boolean isActive;
	
	public CustomerContact() {
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
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getFaxNumber() {
		return faxNumber;
	}
	public void setFaxNumber(String faxNumber) {
		this.faxNumber = faxNumber;
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
	
	public CustomerServicingGroup getiCustomerServicingGroup() {
		return iCustomerServicingGroup;
	}
	public void setiCustomerServicingGroup(CustomerServicingGroup iCustomerServicingGroup) {
		this.iCustomerServicingGroup = iCustomerServicingGroup;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
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
	public List<CustomerInvoiceMethodMap> getCustInvoiceMethods() {
		return custInvoiceMethods;
	}
	public void setCustInvoiceMethods(List<CustomerInvoiceMethodMap> custInvoiceMethods) {
		this.custInvoiceMethods = custInvoiceMethods;
	}
	@Override
	public String toString() {
		return "CustomerContact [Id=" + Id + ", iCustomer=" + iCustomer + ", iCustomerServicingGroup="
				+ iCustomerServicingGroup + ", custInvoiceMethods=" + custInvoiceMethods + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", emailAddress=" + emailAddress + ", phoneNumber=" + phoneNumber
				+ ", faxNumber=" + faxNumber + ", address=" + address + ", city=" + city + ", state=" + state
				+ ", country=" + country + ", postalcode=" + postalcode + ", createdBy=" + createdBy + ", createdDate="
				+ createdDate + ", modifiedBy=" + modifiedBy + ", modifiedDate=" + modifiedDate + ", isActive="
				+ isActive + "]";
	}
	
	
	
	
	
	
}
