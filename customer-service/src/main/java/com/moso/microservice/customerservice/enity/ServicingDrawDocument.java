package com.moso.microservice.customerservice.enity;

import java.sql.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@JsonFilter("DrawFilter")
@Entity(name="servicing_draw_documents")
public class ServicingDrawDocument {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="seq")
	private int id;
	private String name;
	private String documentClassification;
	private String documentSubClassification;
	private String uploadedBy;
	@CreationTimestamp
	private Date uploadedOn; 
	private String modifiedBy;
	@UpdateTimestamp
	private Date modifiedOn;
	private String builtDocKey;
	private String builtDocVersion;
	private String documentObjectURL;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private DrawDocs iDrawDocs;

	public ServicingDrawDocument() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getUploadedOn() {
		return uploadedOn;
	}

	public void setUploadedOn(Date uploadedOn) {
		this.uploadedOn = uploadedOn;
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

	public String getBuiltDocKey() {
		return builtDocKey;
	}

	public void setBuiltDocKey(String builtDocKey) {
		this.builtDocKey = builtDocKey;
	}

	public String getBuiltDocVersion() {
		return builtDocVersion;
	}

	public void setBuiltDocVersion(String builtDocVersion) {
		this.builtDocVersion = builtDocVersion;
	}

	public String getDocumentObjectURL() {
		return documentObjectURL;
	}

	public void setDocumentObjectURL(String documentObjectURL) {
		this.documentObjectURL = documentObjectURL;
	}

	public DrawDocs getiDrawDocs() {
		return iDrawDocs;
	}

	public void setiDrawDocs(DrawDocs iDrawDocs) {
		this.iDrawDocs = iDrawDocs;
	}

	
	public String getDocumentClassification() {
		return documentClassification;
	}

	public void setDocumentClassification(String documentClassification) {
		this.documentClassification = documentClassification;
	}


	public String getDocumentSubClassification() {
		return documentSubClassification;
	}

	public void setDocumentSubClassification(String documentSubClassification) {
		this.documentSubClassification = documentSubClassification;
	}

	public String getUploadedBy() {
		return uploadedBy;
	}

	public void setUploadedBy(String uploadedBy) {
		this.uploadedBy = uploadedBy;
	}

	@Override
	public String toString() {
		return "ServicingDrawDocument [id=" + id + ", name=" + name + ", documentClassification="
				+ documentClassification + ", documentSubClassification=" + documentSubClassification + ", uploadedBy="
				+ uploadedBy + ", uploadedOn=" + uploadedOn + ", modifiedBy=" + modifiedBy + ", modifiedOn="
				+ modifiedOn + ", builtDocKey=" + builtDocKey + ", builtDocVersion=" + builtDocVersion
				+ ", documentObjectURL=" + documentObjectURL + ", iDrawDocs=" + iDrawDocs + "]";
	}
	
	
	
	
}
