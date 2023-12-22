package com.practice.chin.atla;

import java.util.List;

public class Report {
	
	int totalSize;
	List<String> labelsList;
	public Report(int totalSize, List<String> labelsList) {
		super();
		this.totalSize = totalSize;
		this.labelsList = labelsList;
	}
	public int getTotalSize() {
		return totalSize;
	}
	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}
	public List<String> getLabelsList() {
		return labelsList;
	}
	public void setLabelsList(List<String> labelsList) {
		this.labelsList = labelsList;
	}
	@Override
	public String toString() {
		return "Report [totalSize=" + totalSize + ", labelsList=" + labelsList + "]";
	}
	
	
	
}
