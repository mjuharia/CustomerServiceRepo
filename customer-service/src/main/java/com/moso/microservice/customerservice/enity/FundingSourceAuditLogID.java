package com.moso.microservice.customerservice.enity;

import java.io.Serializable;



public class FundingSourceAuditLogID implements Serializable {
	
	private int builtSourceID;
		
	private int version;
	
	public FundingSourceAuditLogID() {
		super();
	}

	public FundingSourceAuditLogID(int builtSourceID, int version) {
		super();
		this.builtSourceID = builtSourceID;
		this.version = version;
	}
	
	
	

}
