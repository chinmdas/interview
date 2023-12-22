package com.practice.chin.atla;

public class FileMetaData {
	
	String filename;
	String fileLabel;
	int fileSize;
	
	public FileMetaData(String filename, String fileLabel, int fileSize) {
		super();
		this.filename = filename;
		this.fileLabel = fileLabel;
		this.fileSize = fileSize;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getFileLabel() {
		return fileLabel;
	}
	public void setFileLabel(String fileLabel) {
		this.fileLabel = fileLabel;
	}
	public int getFileSize() {
		return fileSize;
	}
	public void setFileSize(int fileSize) {
		this.fileSize = fileSize;
	}
	
	

}
