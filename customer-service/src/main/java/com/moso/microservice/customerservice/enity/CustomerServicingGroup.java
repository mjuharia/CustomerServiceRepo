package com.moso.microservice.customerservice.enity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity(name="customer_servicing_group")
public class CustomerServicingGroup {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="seq")
	private Integer Id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private CustomerLocation iCustomerLocation;
	
	@OneToMany(mappedBy = "iCustomerServicingGroup")
	@JsonIgnore
	private List<CustomerWireInstruction> custWireInstructionList;
	@OneToMany(mappedBy = "iCustomerServicingGroup")
	@JsonIgnore
	private List<CustomerContact> custContactList;
	private String name;
	private String alias;
	private Boolean isActive;
	public CustomerServicingGroup() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	
	
	public List<CustomerWireInstruction> getCustWireInstructionList() {
		return custWireInstructionList;
	}
	public void setCustWireInstructionList(List<CustomerWireInstruction> custWireInstructionList) {
		this.custWireInstructionList = custWireInstructionList;
	}
	public List<CustomerContact> getCustContactList() {
		return custContactList;
	}
	public void setCustContactList(List<CustomerContact> custContactList) {
		this.custContactList = custContactList;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	public CustomerLocation getiCustomerLocation() {
		return iCustomerLocation;
	}
	public void setiCustomerLocation(CustomerLocation iCustomerLocation) {
		this.iCustomerLocation = iCustomerLocation;
	}
	@Override
	public String toString() {
		return "CustomerServicingGroup [Id=" + Id + ", iCustomerLocation=" + iCustomerLocation
				+ ", custWireInstructionList=" + custWireInstructionList + ", custContactList=" + custContactList
				+ ", name=" + name + ", alias=" + alias + ", isActive=" + isActive + "]";
	}
	
	
}
