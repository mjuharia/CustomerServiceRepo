package com.moso.microservice.customerservice.enity;

import java.time.Instant;

public class S3FileInfo {
	private String fileName;
    private String url;
    private String contentType;
    private Instant lastModified;
    
    public S3FileInfo() {
    	this.fileName = "";
        this.url = "";
        this.contentType = "";
        this.lastModified = Instant.ofEpochMilli(System.currentTimeMillis());
    }

    public S3FileInfo(String fileName, String url, String contentType, Instant lastModified) {
        this.fileName = fileName;
        this.url = url;
        this.contentType = contentType;
        this.lastModified = lastModified;
    }

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public Instant getLastModified() {
		return lastModified;
	}

	public void setLastModified(Instant lastModified) {
		this.lastModified = lastModified;
	}

	@Override
	public String toString() {
		return "S3FileInfo [fileName=" + fileName + ", url=" + url + ", contentType=" + contentType + ", lastModified="
				+ lastModified + "]";
	}
    
}
